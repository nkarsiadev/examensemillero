using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;
using LoginExamen_CondoloStalin.Data;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddDbContext<LoginExamen_CondoloStalinContext>(options =>
    options.UseSqlServer(builder.Configuration.GetConnectionString("LoginExamen_CondoloStalinContext") ?? throw new InvalidOperationException("Connection string 'LoginExamen_CondoloStalinContext' not found.")));

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();
builder.Services.AddCors(c =>
{
    c.AddPolicy("AllowOrigin", options => options.AllowAnyOrigin().AllowAnyMethod().AllowAnyHeader());
});


var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}
app.UseCors(options => options.AllowAnyOrigin().AllowAnyMethod().AllowAnyHeader());



app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
