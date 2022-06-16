using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using BP_CARVAJAL_API.Models;

namespace BP_CARVAJAL_API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UsersController : ControllerBase
    {
        private readonly bp_loginContext _context;

        public UsersController(bp_loginContext context)
        {
            _context = context;
        }

        // GET: api/Users
        [HttpGet]
        public ActionResult GetUsers()
        {
            var lst = (from d in _context.Users
                       select new { Name = d.UserName, LastName = d.UserLastName, Email = d.UserEmail, Age = d.UserAge, Status = d.UserStatus, Rol=d.IdRol }).ToList();

            return Ok(lst);
        }

        [HttpGet("{email}/{password}")]
        public async Task<ActionResult<PersonalizeResponse>> GetUserValidation(string email,string password)
        {
            string exito = "";
            string error = "";

            try
            {
                var resultado = (from d in _context.Users
                                 where d.UserEmail == email
                                 && d.UserPassword == password
                                 select d).ToList();
                if(resultado.Count > 0)
                {
                    exito = "Success!";
                }
                else
                {
                    exito = "Invalid email/password!";
                }
            }
            catch (Exception e)
            {
                error = "Error! Please contact with your admin";
                throw;
            }
            PersonalizeResponse response = new PersonalizeResponse(exito, error);
            return response;
        }

        //GET: api/Users/agcarvajal@espe.edu.ec
        [HttpGet("{email}")]
        public async Task<ActionResult<PersonalizeResponse>> GetUser(string email)
        {
            string exito = "";
            string error = "";

            if (_context.Users == null)
            {
                return NotFound();
            }
            var user = await _context.Users.SingleOrDefaultAsync(p=>p.UserEmail == email);

            if (user != null)
            {
                exito = "1"; // 1 if exist
            }
            else
            {
                exito = "0"; //0 if doesn't exist
            }
            PersonalizeResponse response = new PersonalizeResponse(exito, error);
            return response;
        }

        // PUT: api/Users/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        //[HttpPut("{id}")]
        //public async Task<IActionResult> PutUser(int id, User user)
        //{
        //    if (id != user.UserId)
        //    {
        //        return BadRequest();
        //    }

        //    _context.Entry(user).State = EntityState.Modified;

        //    try
        //    {
        //        await _context.SaveChangesAsync();
        //    }
        //    catch (DbUpdateConcurrencyException)
        //    {
        //        if (!UserExists(id))
        //        {
        //            return NotFound();
        //        }
        //        else
        //        {
        //            throw;
        //        }
        //    }

        //    return NoContent();
        //}

        // POST: api/Users
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        //[HttpPost]
        //public async Task<ActionResult<User>> PostUser(User user)
        //{
        //  if (_context.Users == null)
        //  {
        //      return Problem("Entity set 'bp_loginContext.Users'  is null.");
        //  }
        //    _context.Users.Add(user);
        //    try
        //    {
        //        await _context.SaveChangesAsync();
        //    }
        //    catch (DbUpdateException)
        //    {
        //        if (UserExists(user.UserId))
        //        {
        //            return Conflict();
        //        }
        //        else
        //        {
        //            throw;
        //        }
        //    }

        //    return CreatedAtAction("GetUser", new { id = user.UserId }, user);
        //}

        // DELETE: api/Users/5
        //[HttpDelete("{id}")]
        //public async Task<IActionResult> DeleteUser(int id)
        //{
        //    if (_context.Users == null)
        //    {
        //        return NotFound();
        //    }
        //    var user = await _context.Users.FindAsync(id);
        //    if (user == null)
        //    {
        //        return NotFound();
        //    }

        //    _context.Users.Remove(user);
        //    await _context.SaveChangesAsync();

        //    return NoContent();
        //}

        private bool UserExists(int id)
        {
            return (_context.Users?.Any(e => e.UserId == id)).GetValueOrDefault();
        }
    }
}
