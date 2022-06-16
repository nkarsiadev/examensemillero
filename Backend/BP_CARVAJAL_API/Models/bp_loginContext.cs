using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace BP_CARVAJAL_API.Models
{
    public partial class bp_loginContext : DbContext
    {
        public bp_loginContext()
        {
        }

        public bp_loginContext(DbContextOptions<bp_loginContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Rol> Rols { get; set; } = null!;
        public virtual DbSet<User> Users { get; set; } = null!;

//        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
//        {
//            if (!optionsBuilder.IsConfigured)
//            {
//#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see http://go.microsoft.com/fwlink/?LinkId=723263.
//                optionsBuilder.UseSqlServer("Data Source=DESKTOP-3R4Q1SJ\\SQLEXPRESS;Initial Catalog=bp_login;Integrated Security=True;Pooling=False");
//            }
//        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Rol>(entity =>
            {
                entity.HasKey(e => e.IdRol)
                    .IsClustered(false);

                entity.ToTable("ROL");

                entity.Property(e => e.IdRol)
                    .ValueGeneratedNever()
                    .HasColumnName("ID_ROL");

                entity.Property(e => e.NameRol)
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("NAME_ROL");

                entity.Property(e => e.StatusRol)
                    .HasMaxLength(50)
                    .IsUnicode(false)
                    .HasColumnName("STATUS_ROL");
            });

            modelBuilder.Entity<User>(entity =>
            {
                entity.HasKey(e => e.UserId)
                    .IsClustered(false);

                entity.ToTable("USER");

                entity.HasIndex(e => e.IdRol, "RELATIONSHIP_1_FK");

                entity.Property(e => e.UserId)
                    .ValueGeneratedNever()
                    .HasColumnName("USER_ID");

                entity.Property(e => e.IdRol).HasColumnName("ID_ROL");

                entity.Property(e => e.UserAge).HasColumnName("USER_AGE");

                entity.Property(e => e.UserEmail)
                    .HasMaxLength(100)
                    .IsUnicode(false)
                    .HasColumnName("USER_EMAIL");

                entity.Property(e => e.UserLastName)
                    .HasMaxLength(100)
                    .IsUnicode(false)
                    .HasColumnName("USER_LAST_NAME");

                entity.Property(e => e.UserName)
                    .HasMaxLength(100)
                    .IsUnicode(false)
                    .HasColumnName("USER_NAME");

                entity.Property(e => e.UserPassword)
                    .HasMaxLength(500)
                    .IsUnicode(false)
                    .HasColumnName("USER_PASSWORD");

                entity.Property(e => e.UserStatus)
                    .HasMaxLength(10)
                    .IsUnicode(false)
                    .HasColumnName("USER_STATUS");

                entity.HasOne(d => d.IdRolNavigation)
                    .WithMany(p => p.Users)
                    .HasForeignKey(d => d.IdRol)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_USER_RELATIONS_ROL");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
