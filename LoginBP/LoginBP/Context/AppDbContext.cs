using LoginBP.Models;
using Microsoft.EntityFrameworkCore;

namespace LoginBP.Context
{
    public class AppDbContext : DbContext
    {
        public AppDbContext (DbContextOptions<AppDbContext>options): base(options)
        {

        }
        public DbSet<Usuario> login { get; set; }
    }
}
