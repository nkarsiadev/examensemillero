using System.ComponentModel.DataAnnotations;

namespace LoginBP.Models
{
    public class Usuario
    {
        [Key]
        public int id_user { get; set; }
        public string name_user { get; set; }
        public string lastn_user { get; set; }

        public string email_user { get; set; }

        public string password_user { get; set; }
        public int age_user { get; set; }
        public string status { get; set; }
        public int id_rol { get; set; } 
    }
}
