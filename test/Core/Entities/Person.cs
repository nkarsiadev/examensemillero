namespace Core.Entities
{
    public class Person : BaseEntity
    {
        public string name { get; set; }
        public string last_name { get; set; }
        public string email { get; set; }
    }
}