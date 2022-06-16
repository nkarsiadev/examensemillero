using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using LoginExamen_CondoloStalin.Models;

namespace LoginExamen_CondoloStalin.Data
{
    public class LoginExamen_CondoloStalinContext : DbContext
    {
        public LoginExamen_CondoloStalinContext (DbContextOptions<LoginExamen_CondoloStalinContext> options)
            : base(options)
        {
        }

        public DbSet<LoginExamen_CondoloStalin.Models.Usuario>? Usuario { get; set; }
    }
}
