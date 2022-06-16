const apiURL = "http://localhost:8090/";

const axiosAllUsers = () =>  axios.get(apiURL + "users/")
    .then(response => {
        return response;
    })

const axiosUserByEmail = (email) => axios.get(apiURL + "users/" + email)
    .then(response => {
        return response;
    }).catch(function (error) {
        console.log(error.config);
    });

const axiosUserLogin = (email, password) => axios.get(apiURL + "users/" + email + "/" + password)
    .then(response => {
        console.log(response)
        return response;
    })


window.addEventListener("DOMContentLoaded", function (event){
    let form = document.getElementById("form_login");
    form.addEventListener("submit", async function(event){
        event.preventDefault();
        var emailOk = false;
        var passwordOk = false;
        //Email
        var input_email = document.querySelector("#input_email");
        document.querySelector("#email_container .input_error").innerHTML = '';
        if (!input_email.value == ""){
            var index_one = input_email.value.indexOf('@');
            var index_two = input_email.value.indexOf('.');
            if (!((index_one < 0 || index_two < 0) || index_one > index_two)){
                let json = await axiosUserByEmail(input_email.value);
                if (json?.data){
                    emailOk = true;
                }else{
                    document.querySelector("#email_container .input_error").innerHTML = 'Usuario no encontrado';
                }
            }else{
                document.querySelector("#email_container .input_error").innerHTML = 'Correo no tiene un formato valido';
            }
        }else{
            document.querySelector("#email_container .input_error").innerHTML = 'El usuario es Obligatorio';
        }
        var input_password = document.querySelector("#input_password");
        document.querySelector("#password_container .input_error").innerHTML = '';
        if(!input_password.value == ""){
            if (emailOk){
                let json = await axiosAllUsers(input_email.value, input_password.value);
                if (json?.data[0]?.email && json?.data[0]?.password){
                    passwordOk = true;
                }else{
                    document.querySelector("#password_container .input_error").innerHTML = 'Contrasena incorrecta';
                }
            }
        }else{
            document.querySelector("#password_container .input_error").innerHTML = 'La password es Obligatoria';
        }
        if (emailOk && passwordOk){
            window.location.href = "listUsers.html";
        }
    })
})