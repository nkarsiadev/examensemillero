const API_URL = "localhost:8080/login/users";

//Consultar Usuarios
const gerUsers = () => {
  axios
    .get(`${API_URL}`)
    .then((res) => {
      const userList = document.querySelector("#userList");
      const users = res.data;
      console.log(users);
      heroes.forEach((user) => {
        userList.innerHTML += `<table class="table table-striped">
        <table class="table">
            <thead>
              <tr>
                <th scope="col">Id</th>
                <th scope="col">Status</th>
                <th scope="col">Age</th>
                <th scope="col">Email</th>
                <th scope="col">LastName</th>
                <th scope="col">Name</th>
                <th scope="col">Pass</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">1</th>
                <td>${user.user_name}</td>
                <td>${user.user_last_name}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.age}</td>
                <td>${user.status}</td>
              </tr>
            </tbody>
          </table>
    </table>`;
      });
      document.querySelector(".spinner").style.display = "none";
    })
    .catch((err) => {
      console.error(err);
    });
};

window.addEventListener("DOMContentLoaded", () => {
  gerUsers();
});