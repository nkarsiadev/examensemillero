using System.ComponentModel.DataAnnotations;

namespace LoginExamen_CondoloStalin.Models
{
    public class Usuario
    {
        [Key]
        public int ID_USUARIO { get; set; }
        public string NAME_USUARIO {get; set;}
        public string LAST_NAME_USUARIO {get; set;}
        public string EMAIL_USUARIO {get; set; } 
        public string PASSWORD_USUARIO { get; set; }
        public int EDAD_USUARIO { get; set; }
        public string STATUS { get; set; }
    }
    
}
