using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using loginApi.Data;
using loginApi.Models;
using Microsoft.AspNetCore.Cors;

namespace loginApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class usuariosController : ControllerBase
    {
        private readonly loginApiContext _context;

        public usuariosController(loginApiContext context)
        {
            _context = context;
        }

        // GET: api/usuarios
        [HttpGet]
        [EnableCors("AllowOrigin")]
        public async Task<ActionResult<IEnumerable<usuario>>> Getusuario()
        {
          if (_context.usuario == null)
          {
              return NotFound();
          }
            return await _context.usuario.ToListAsync();
        }

        // GET: api/usuarios/5
        [HttpGet("{id}")]
        [EnableCors("AllowOrigin")]
        public async Task<ActionResult<usuario>> Getusuario(int id)
        {
          if (_context.usuario == null)
          {
              return NotFound();
          }
            var usuario = await _context.usuario.FindAsync(id);

            if (usuario == null)
            {
                return NotFound();
            }

            return usuario;
        }

        // PUT: api/usuarios/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        [EnableCors("AllowOrigin")]
        public async Task<IActionResult> Putusuario(int id, usuario usuario)
        {
            if (id != usuario.idUsuario)
            {
                return BadRequest();
            }

            _context.Entry(usuario).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!usuarioExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/usuarios
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        [EnableCors("AllowOrigin")]
        public async Task<ActionResult<usuario>> Postusuario(usuario usuario)
        {
          if (_context.usuario == null)
          {
              return Problem("Entity set 'loginApiContext.usuario'  is null.");
          }
            _context.usuario.Add(usuario);
            await _context.SaveChangesAsync();

            return CreatedAtAction("Getusuario", new { id = usuario.idUsuario }, usuario);
        }

        // DELETE: api/usuarios/5
        [HttpDelete("{id}")]
        [EnableCors("AllowOrigin")]
        public async Task<IActionResult> Deleteusuario(int id)
        {
            if (_context.usuario == null)
            {
                return NotFound();
            }
            var usuario = await _context.usuario.FindAsync(id);
            if (usuario == null)
            {
                return NotFound();
            }

            _context.usuario.Remove(usuario);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool usuarioExists(int id)
        {
            return (_context.usuario?.Any(e => e.idUsuario == id)).GetValueOrDefault();
        }
    }
}
