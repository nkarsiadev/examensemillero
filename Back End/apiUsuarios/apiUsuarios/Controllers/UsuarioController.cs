using apiUsuarios.Context;
using apiUsuarios.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace apiUsuarios.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UsuarioController : Controller
    {
        private readonly AppDbContext context;

        public UsuarioController(AppDbContext context)
        {
            this.context = context;
        }

        [HttpGet]

        public ActionResult Get()
        {
            try
            {
                return Ok(context.usuarios.ToList());
            }catch (Exception ex)
            {
                return BadRequest(ex.Message);
            }
        }

        [HttpGet("{id}", Name ="GetUsuario")]

        public ActionResult Get(int ci)
        {
            try
            {
                var usuario = context.usuarios.FirstOrDefault(u => u.ci == ci);
                return Ok(usuario);
            }
            catch (Exception ex)
            {
                return BadRequest(ex.Message);
            }
        }

        [HttpPost]

        public ActionResult Post([FromBody]Usuarios usuario)
        {
            try
            {
                context.usuarios.Add(usuario);
                context.SaveChanges();
                return CreatedAtRoute("GetUsuario", new { ci = usuario.ci }, usuario);
            }
            catch (Exception ex)
            {
                return BadRequest(ex.Message);
            }
        }

      

        [HttpPut ("{ci}")]

        public ActionResult Put(int ci, [FromBody] Usuarios usuario)
        {
            try
            {
                if (usuario.ci == ci)
                {
                    context.Entry(usuario).State=EntityState.Modified;
                    context.SaveChanges();
                    return CreatedAtRoute("GetUsuario", new { ci = usuario.ci }, usuario);
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

        [HttpDelete("{ci}")]

        public ActionResult Delete(int ci)
        {
            try
            {
                var usuario = context.usuarios.FirstOrDefault(u => u.ci == ci);
                if (usuario != null)
                {
                    context.usuarios.Remove(usuario);
                    context.SaveChanges();
                    return Ok(ci);
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

        private ActionResult Ok(Func<List<Usuarios>> toList)
        {
            throw new NotImplementedException();
        }
    }
}
