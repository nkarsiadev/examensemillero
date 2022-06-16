using System;
using System.Collections.Generic;

namespace BP_CARVAJAL_API.Models
{
    public partial class Rol
    {
        public Rol()
        {
            Users = new HashSet<User>();
        }

        public int IdRol { get; set; }
        public string? NameRol { get; set; }
        public string? StatusRol { get; set; }

        public virtual ICollection<User> Users { get; set; }
    }
}
