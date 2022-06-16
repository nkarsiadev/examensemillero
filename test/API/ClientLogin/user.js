window.addEventListener('DOMContentLoaded', function (e) {

    e.preventDefault();

    const apiUrl = "https://localhost:5001/User";

    axios.get(`${apiUrl}`).then(response => {
        console.log(response);
        var body = document.getElementById("lstusers");
        var html= "";
        var cont=1;
        response.data.forEach(el => {
             html += `<tr ${el.Id}>
                <td>${cont}</td>
                <td>${el.name} ${el.last_name}</td>
                <td>${el.email}</td>
                <td>${el.age_user}</td>
                <td>${el.roles.name_role}</td>
                <td>
                    <a class="btn btn-success" href="">Editar</a>
                    <a  class="btn btn-danger"href="">Eliminar</a>
                </td>
            </tr>`;
            cont++;
        });

        body.innerHTML = html;
    });

    debugger;
    var btn_close = this.document.querySelector("#close");
    btn_close.addEventListener('click', function (e) {
        let timerInterval
            Swal.fire({
                title: "Bye!! Nos veremos :)",
                timer: 1000,
                timerProgressBar: true,
                didOpen: () => {
                    Swal.showLoading()
                    const b = Swal.getHtmlContainer().querySelector('b')
                    timerInterval = setInterval(() => {
                        b.textContent = Swal.getTimerLeft()
                    }, 100)
                },
                willClose: () => {
                    clearInterval(timerInterval);
                    window.location.href = "login.html";
                }
            }).then((result) => {
                if (result.dismiss === Swal.DismissReason.timer) {
                    console.log('I was closed by the timer')
                }
            })
    });

   
});
