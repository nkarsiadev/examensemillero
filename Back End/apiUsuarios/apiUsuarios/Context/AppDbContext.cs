using apiUsuarios.Models;
using Microsoft.EntityFrameworkCore;

namespace apiUsuarios.Context
{
    public class AppDbContext: DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> options): base(options)
        {

        }
        public DbSet<Usuarios> usuarios { get; set; }
    }
}
