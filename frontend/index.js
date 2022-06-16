let userInput = document.querySelector(".usuario-input");
let contrasenaInput = document.querySelector(".contrasena-input");
// console.log(showPassword);

let loginButton = document.querySelector(".btn-login");

// document.addEventListener("click", imprimirInputs);
let formLogin = document.querySelector(".login");
formLogin.addEventListener("submit", function (e) {
  e.preventDefault();
  axios
    .post("http://localhost:8080/usuarios/login", {
      usuario: userInput.value,
      contrasena: contrasenaInput.value,
    })
    .then((res) => {
      console.log(res);
      if (res.data == userInput.value) {
        alert(`Hola ${userInput.value}!!!`);
      } else if (res.data == "Usuario no encontrado") {
        alert(res.data);
      } else {
        alert(res.data);
      }
    })
    .catch((err) => console.log(err));
  console.log(userInput.value, contrasenaInput.value);
});

// function imprimirInputs(e) {

//   console.log(userInput.value, contrasenaInput.value);
// }

let showPassword = document.querySelector(".show");
console.log(contrasenaInput);

showPassword.addEventListener("click", (e) => {
  e.preventDefault();
  if (showPassword.innerHTML == "Show password") {
    contrasenaInput.setAttribute("type", "text");
    // console.log(contrasenaInput);
    showPassword.innerHTML = "Hide password";
  } else if (showPassword.innerHTML == "Hide password") {
    contrasenaInput.setAttribute("type", "password");
    showPassword.innerHTML = "Hide password";
    // console.log(contrasenaInput);
  }
  //   console.log(showPassword.innerHTML);
});
