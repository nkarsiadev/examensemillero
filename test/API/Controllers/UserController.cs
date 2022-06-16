using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Core.Entities;
using Core.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace API.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class UserController : ControllerBase
    {
        private readonly IUserRepository _repo;
        public UserController(IUserRepository repo)
        {
            _repo = repo;
        }

        //GET: api/User
        [HttpGet]
        public async Task<ActionResult<IReadOnlyList<User>>> GetUsers()
        {
            var users = await _repo.GerUsersAsync();
            return Ok(users);
        }


        [HttpGet("Login")]
        public async Task<ActionResult> Login(string email, string password)
        {
            var resp_user = await _repo.Login(email,password);
            if (resp_user == "notfound")
            {
                return BadRequest("Usuario no encontrado");
            }
            if (resp_user == "wrong")
            {
                return BadRequest("Password Incorrecta");
            }
            return Ok(resp_user);      
                 
        }

    }
}