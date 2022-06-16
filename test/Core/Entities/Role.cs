using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Core.Entities
{
    public class Role : BaseEntity
    {
        public string name_role { get; set; }
        public bool status_role { get; set; }
    }
}