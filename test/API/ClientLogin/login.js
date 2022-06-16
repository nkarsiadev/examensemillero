window.addEventListener('DOMContentLoaded', function (e) {

    const apiUrl = "https://localhost:5001/User/Login";

    var validate = true;

    var btn_login = this.document.querySelector("#login");
    btn_login.addEventListener('click', function (e) {
        e.preventDefault();

        var email = document.getElementById("email").value;
        var pass = document.getElementById("pass").value;

        validateForm(email, pass);
        validateEmail(email);

        if (validate) {
            const paramsRequest = {
                email: email,
                password: pass
            }

            axios.get(`${apiUrl}`, {
                params: {
                    ...paramsRequest
                }
            }).then(response => {
                let timerInterval
                Swal.fire({
                    title: response.data,
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
                        window.location.href = "users.html";
                    }
                }).then((result) => {
                    if (result.dismiss === Swal.DismissReason.timer) {
                        console.log('I was closed by the timer')
                    }
                })
            }, error => console.log(error));
        }


    });

    function validateForm(email, pass) {
        debugger;
        if (email == "" && pass != "") {
            Swal.fire(
                'Ingrese un email',
                '',
                'error'
            )
            document.getElementById("email").classList.add("focus");
            validate = false;
        }
        if (pass == "" && email != "") {
            Swal.fire(
                'Ingrese una contrasenia',
                '',
                'error'
            )
            document.getElementById("pass").classList.add("focus");
            validate = false;
        }
        if (pass == "" && email == "") {
            Swal.fire(
                'Los campos estan vacios',
                '',
                'error',
            )
            validate = false;
        }

    }

    function validateEmail(email) {
        if (email != "") {
            if (!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
                Swal.fire(
                    'El email es incorrecto',
                    '',
                    'error'
                )
                validate = false;
            }
        }
    }




});