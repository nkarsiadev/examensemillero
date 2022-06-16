using System;
using System.Collections.Generic;

namespace BP_CARVAJAL_API.Models
{
    public partial class User
    {
        public int UserId { get; set; }
        public int IdRol { get; set; }
        public string? UserName { get; set; }
        public string? UserLastName { get; set; }
        public string? UserEmail { get; set; }
        public string? UserPassword { get; set; }
        public int? UserAge { get; set; }
        public string? UserStatus { get; set; }

        public virtual Rol IdRolNavigation { get; set; } = null!;
    }
}
