using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using loginApi.Models;

namespace loginApi.Data
{
    public class loginApiContext : DbContext
    {
        public loginApiContext (DbContextOptions<loginApiContext> options)
            : base(options)
        {
        }

        public DbSet<loginApi.Models.usuario>? usuario { get; set; }
    }
}
