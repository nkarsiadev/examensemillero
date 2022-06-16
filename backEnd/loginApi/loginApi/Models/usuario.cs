using System.ComponentModel.DataAnnotations;

namespace loginApi.Models
{
    public class usuario
    {
        [Key]
        public int  idUsuario { get; set; }
        public string? nombreUsuario { get; set; }
        public string? apellidoUsuario { get; set; }
        public string? emailUsuario { get; set; }
        public string? contrasenaUsuario { get; set; }
        public int edadUsuario { get; set; }
        public string? estadoUsuario { get; set; }



    }
}
