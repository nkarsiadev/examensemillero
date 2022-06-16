window.addEventListener("DOMContentLoaded", async function (event) {
  validateSession();
});

function validateSession() {
  if (!localStorage.getItem("session")) {
    alert("Debe iniciar sesión para acceder a esta página");
    window.location.href = "./index.html";
  }
}
