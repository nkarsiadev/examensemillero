const urlApi = "http://localhost:8085/api/semillero/session";

window.addEventListener("DOMContentLoaded", function (event) {});

async function loginSession(event) {
  event.preventDefault();

  var userName,
    mail = "";
  var inputUser = document.getElementById("input-user");
  var inputPass = document.getElementById("input-pass");
  var booleanInputs = validationCamp(inputUser, inputPass);
  if (booleanInputs) {
    await beforeValidation(inputUser, inputPass);
  }
}

function login(user, mail, pass) {
  return axios.post(urlApi + `?name=${user}&mail=${mail}&password=${pass}`);
}

async function beforeValidation(inputUser, inputPass) {
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

function validationCamp(inputUser, inputPass) {
  if (inputUser.value == "" || inputPass.value == "") {
    document.querySelector("#input-pass-container .error-input").style.color =
      "red";
    document.querySelector("#input-pass-container .error-input").innerHTML =
      "Debe llenar el campo contraseña";

    document.querySelector("#input-user-container .error-input").style.color =
      "red";
    document.querySelector("#input-user-container .error-input").innerHTML =
      "Debe llenar el campo usuario";
    return false;
  } else {
    document.querySelector("#input-user-container .error-input").style.color =
      "green";
    document.querySelector("#input-user-container .error-input").innerHTML =
      "Campo llenado correctamente!";
    document.querySelector("#input-pass-container .error-input").style.color =
      "green";
    document.querySelector("#input-pass-container .error-input").innerHTML =
      "campo llenado correctamente!";
    return true;
  }
}
