const API_URL = "http://localhost:8080/api/usuarios";

//Consultar Usuarios
const getUsuarios = () => {
  axios
    .get(`${API_URL}`)
    .then((res) => {
      const usuariosList = document.querySelector("#usuariosList");
      const usuarios = res.data;
      console.log(usuarios);
      usuarios.forEach((usuario) => {
        usuariosList.innerHTML += `<div class="card my-3 bg-success">
            <div class="row g-10 p-5">
            
            <div class="col-md-12 text-light d-flex flex-column justify-content-center">
              <h2 >Nombre: ${usuario.name_usuario} ${usuario.last_name_usuario}</h2>    
              <p> Su correo es: ${usuario.email_usuario}</p>
              <p> Su edad es:  ${usuario.edad_usuario}</p>
          
            </div>
            
            </div>
            </div>`;
      });
      document.querySelector(".spinner").style.display = "none";
    })
    .catch((err) => {
      console.error(err);
    });
};

window.addEventListener("DOMContentLoaded", () => {
  getUsuarios();
});
