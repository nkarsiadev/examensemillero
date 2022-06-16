using LoginBP.Context;
using LoginBP.Models;
using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace LoginBP.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UsuarioController : ControllerBase
    {
        private readonly AppDbContext context;
        public UsuarioController(AppDbContext context)
        {
            this.context = context;
        }
        // GET: api/<UsuarioController>
        [HttpGet]
        [EnableCors("AllowOrigin")]
        public ActionResult Get()
        {
            try
            {
                return Ok(context.login.ToList());
            }
            catch (Exception ex)
            {
                return BadRequest(ex.Message);
            }
        }

        // GET api/<UsuarioController>/5
        [HttpGet("{id}", Name ="GetUsuario")]
        [EnableCors("AllowOrigin")]
        public ActionResult Get(int id)
        {
            try
            {
                var usuario = context.login.FirstOrDefault(f => f.id_user == id);
                return Ok(usuario);
            }
            catch (Exception ex)
            {
                return BadRequest(ex.Message);
            }
        }

        // POST api/<UsuarioController>
        [HttpPost]
        [EnableCors("AllowOrigin")]
        public ActionResult Post([FromBody] Usuario usuario)
        {
            try
            {
                context.login.Add(usuario);
                context.SaveChanges();
                return CreatedAtRoute("GetUsuario", new { id = usuario.id_user }, usuario);
            }
            catch (Exception ex)
            {
                return BadRequest(ex.Message);
            }
        }

        // PUT api/<UsuarioController>/5
        [HttpPut("{id}")]
        [EnableCors("AllowOrigin")]
        public ActionResult Put(int id, [FromBody] Usuario usuario)
        {
            try
            {
                if (usuario.id_user == id)
                {
                    context.Entry(usuario).State = EntityState.Modified;
                    context.SaveChanges();
                    return CreatedAtRoute("GetUsuario", new { id = usuario.id_user }, usuario);
                }
                else
                {
                    return BadRequest();
                }
            }
            catch (Exception ex)
            {
                return BadRequest(ex.Message);
            }
        }

        // DELETE api/<UsuarioController>/5
        [HttpDelete("{id}")]
        [EnableCors("AllowOrigin")]
        public ActionResult Delete(int id)
        {
            try
            {
                var usuario = context.login.FirstOrDefault(f => f.id_user == id);
                if (usuario != null)
                {
                    context.login.Remove(usuario);
                    context.SaveChanges();
                    return Ok(id);
                }
                else
                {
                    return BadRequest();
                }
            }
            catch (Exception ex)
            {
                return BadRequest(ex.Message);
            }
        }
    }
}
