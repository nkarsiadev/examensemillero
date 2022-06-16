using Core.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace Infrastructure.Data.Config
{
    public class UsersConfiguration : IEntityTypeConfiguration<User>
    {
        public void Configure(EntityTypeBuilder<User> builder)
        {
            builder.Property(u=>u.name).IsRequired().HasMaxLength(100);
            builder.Property(u=>u.last_name).IsRequired().HasMaxLength(100);
            builder.Property(u=>u.email).IsRequired().HasMaxLength(100);
            builder.Property(u=>u.status).IsRequired();            

        }
        
    }
}