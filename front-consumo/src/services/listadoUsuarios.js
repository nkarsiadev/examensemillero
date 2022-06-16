const urlApi = "http://localhost:8085/api/semillero/usuarios";

window.addEventListener("DOMContentLoaded", function (event) {
  var listar = document.querySelector("#listadoUsuarios");

  generarListaTabla(listar);
});

function generarListaTabla(table) {
  console.log(table);
  //add more td in the table
  var tr = document.createElement("tr");
  var nombres = document.createElement("td");
  var correo = document.createElement("td");
  var edad = document.createElement("td");
  var estado = document.createElement("td");
  var rol = document.createElement("td");
  var acciones = document.createElement("td");

  
  var listJson = await login(userName, mail, inputPass.value).then(function (
    response
  ) {
    return listJson;
  });
  console.log()
  listJson.data.forEach(function (element) {
    nombres.innerHTML = `${element.nameUsuario}  ${element.lastNameUsuario}`;
  correo.innerHTML = "asdas";
    edad.innerHTML = "asdas";
    estado.innerHTML = "asdas";
    rol.innerHTML = "asdas";
    acciones.innerHTML = "asdas";

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
