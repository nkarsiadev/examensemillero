using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Core.Entities
{
    public class User : Person
    {
        public string password_user { get; set; }
        public int age_user { get; set; }
        public bool status { get; set; }
        public int RoleId { get; set; } 
        public Role Roles { get; set; }
    }
}