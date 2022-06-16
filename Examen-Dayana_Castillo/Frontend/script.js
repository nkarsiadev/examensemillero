window.addEventListener("DOMContentLoaded", (e)=>{
  loginbox();
})

const API_URL = "http://localhost:8080/usuario";

//Obtener Usuarios de la APi
const getUser = () => {
  axios
    .get(`${API_URL}`)
    .then((res) => {
      const loginbox = document.querySelector("#loginbox");
      const usuario = res.data;

      console.log(usuario);
      usuario.forEach((usuario) => {
        loginbox.innerHTML += `
                
        <div class="card my-3 bg-dark">
            <div class="row g-10 p-5">
            
            <div class="col-md-12 text-light d-flex flex-column justify-content-center">
            <h2>${usuario.nombre}</h2>    
            <p> Su email es: ${usuario.email}</p>
            <p> Su password es:  ${usuario.password}</p>

            key = "${usuario.password}"
            password = input("Introduce la clave: ")
            if key == ${usuario.password}.lower():
                print("La clave coincide")
            else:
                print("La clave no coincide")

            <div class="d-none">
                      </div>
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
  getUser();
});
