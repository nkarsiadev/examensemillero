namespace BP_CARVAJAL_API.Models
{
    public class PersonalizeResponse
    {
        public string respuesta { get; set; }
        public string error { get; set; }

        public PersonalizeResponse(string respuesta, string error)
        {
            this.respuesta = respuesta;
            this.error = error;
        }
    }
}
