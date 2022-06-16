const urlApi = "http://localhost:8085/api/semillero/session";

window.addEventListener("DOMContentLoaded", function (event) {});

async function loginSession(event) {
  event.preventDefault();
  var userName,
    mail = "";
  var inputUser = document.getElementById("input-user");
  var inputPass = document.getElementById("input-pass");

  var firstLetter = inputUser.value.indexOf(".");
  var lastLetter = inputUser.value.lastIndexOf("@");

  if (
    firstLetter == -1 ||
    lastLetter == -1 ||
    firstLetter < lastLetter ||
    lastLetter == 0
  ) {
    userName = inputUser.value;
    mail = "";
  } else {
    userName = "";
    mail = inputUser.value;
  }

  var sessionData = await login(userName, mail, inputPass.value).then(function (
    response
  ) {
    return response;
  });
  console.log(sessionData.data);
  if (sessionData.status == 200) {
    if (sessionData.data.emailUsuario) {
      localStorage.setItem("session", JSON.stringify(sessionData.data));
      window.location.href = "./listar.html";
    } else {
      alert("Contraseña incorrecta!");
    }
  } else {
    alert("Usuario no encontrado!");
  }
}

function login(user, mail, pass) {
  return axios.post(urlApi + `?name=${user}&mail=${mail}&password=${pass}`);
}
