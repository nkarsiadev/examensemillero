const urlApi = "http://localhost:8085/api/semillero/usuarios";

window.addEventListener("DOMContentLoaded", async function (event) {
  var listar = document.querySelector("#listadoUsuarios");

  await generarListaTabla(listar);
});

async function generarListaTabla(table) {
  console.log(table);
  //add more td in the table
  var tr = document.createElement("tr");
  var nombres = document.createElement("td");
  var correo = document.createElement("td");
  var edad = document.createElement("td");
  var estado = document.createElement("td");
  var rol = document.createElement("td");
  var acciones = document.createElement("td");
  var numList = document.createElement("td");

  var listJson = await getAllUsers().then(function (response) {
    return response;
  });
  let count = 0;
  listJson.data.forEach(function (element) {
    count++;
    numList.innerHTML = count;
    nombres.innerHTML = `${element.nameUsuario}  ${element.lastNameUsuario}`;
    correo.innerHTML = element.emailUsuario;
    edad.innerHTML = element.edadUsuarios;
    estado.innerHTML = element.status;
    rol.innerHTML = element.rol.nameRol;
    acciones.innerHTML = `<button>Editar</button><button>Eliminar</button>`;

    tr.appendChild(numList);
    tr.appendChild(nombres);
    tr.appendChild(correo);
    tr.appendChild(edad);
    tr.appendChild(estado);
    tr.appendChild(rol);
    tr.appendChild(acciones);
    table.appendChild(tr);
  });
}

function getAllUsers() {
  return axios.get(urlApi);
}

function closeSession() {
  localStorage.removeItem("session");
  window.location.href = "./index.html";
}
