window.addEventListener("DOMContentLoaded", () => {
  const USUARIOS_LIST = document.querySelector("#usuariosLista");
  const API_URL = "https://localhost:7111/api/Usuario";
  let USUARIOS = [];
  async function obtenerUsuarios() {
    let response = await fetch(API_URL);
    let responseJson = await response.json();
    return responseJson;
  }
  obtenerUsuarios()
    .then((res) => {
      USUARIOS = res;
      USUARIOS.forEach((usuario) => {
        USUARIOS_LIST.innerHTML += `
            <div class="usuarios-tarjeta">
                <h2 class="usuarios-tarjeta-nombre">${usuario.name_usuario} ${
          usuario.last_name_usuario
        }</h2>
                <p>${usuario.email_usuario}</p>
                <p>${usuario.edad_usuario} años</p>
                <span class="status ${
                  usuario.status_usuario.trim() == "activo"
                    ? "activo"
                    : "inactivo"
                }">${usuario.status_usuario}</span>
            </div>
            `;
      });
    })
    .catch((err) => {
      console.log(err);
    });
});
