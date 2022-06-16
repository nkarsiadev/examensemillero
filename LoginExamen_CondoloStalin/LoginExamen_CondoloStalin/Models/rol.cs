using System.ComponentModel.DataAnnotations;

namespace LoginExamen_CondoloStalin.Models
{
    public class rol
    {
        [Key]
        public int ID_ROL { get; set; }
        public string NAME_ROL { get; set; }
        public string STATUS_ROL { get; set; }

    }
}
