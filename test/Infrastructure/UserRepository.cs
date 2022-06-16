using System;
using System.Collections.Generic;
using System.IdentityModel.Tokens.Jwt;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;
using Core.Entities;
using Core.Interfaces;
using Infrastructure.Data;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.IdentityModel.Tokens;

namespace Infrastructure
{
    public class UserRepository : IUserRepository
    {
        private readonly LoginContext __context;
        private readonly IConfiguration _config;
        public UserRepository(LoginContext _context,  IConfiguration config)
        {
            _config = config;
            __context = _context;
        }

        public async Task<IReadOnlyList<User>> GerUsersAsync()
        {
            return await __context.Users.Include(u=>u.Roles).ToListAsync();
        }

        public async Task<string> Login(string email_user, string password)
        {
            var user = await __context.Users.Include(u=>u.Roles).FirstOrDefaultAsync(
                u=>u.email.Equals(email_user));
            
            if(user==null){
                return "notfound";
            }else if(user.password_user!=password){
                return "wrong";
            }
            else{
                return "Bienvenid@ "+ user.name +" - "+user.Roles.name_role;
            }
        }



        // private string CreateToken(User user)
        // {
        //     var claims = new List<Claim>
        //     {
        //         new Claim(ClaimTypes.NameIdentifier, user.Id.ToString()),
        //         new Claim(ClaimTypes.Name, user.name)
        //     };

        //     var key = new SymmetricSecurityKey(System.Text.Encoding.UTF8.
        //                                 GetBytes(_config.GetSection("AppSettings:Token").Value));

        //     var creds = new SigningCredentials(key, SecurityAlgorithms.HmacSha512Signature);

        //     var tokenDescriptor = new SecurityTokenDescriptor
        //     {
        //         Subject = new ClaimsIdentity(claims),
        //         Expires = System.DateTime.Now.AddDays(1),
        //         SigningCredentials = creds
        //     };

        //     var tokenHandler = new JwtSecurityTokenHandler();
        //     var token = tokenHandler.CreateToken(tokenDescriptor);

        //     return tokenHandler.WriteToken(token);

        // }

    }
}