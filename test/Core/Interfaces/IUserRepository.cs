using System.Collections.Generic;
using System.Threading.Tasks;
using Core.Entities;

namespace Core.Interfaces
{
    public interface IUserRepository
    {
        Task<IReadOnlyList<User>> GerUsersAsync();
        Task<string> Login(string email, string password);        
    }
}