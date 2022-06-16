window.addEventListener('DOMContentLoaded', function (event) {
    var form_register = document.querySelector('#form-register');
    form_register.addEventListener('submit', function (event) {
        //event.preventDefault();
        var canSubmit = true;

        //correo
        var input_email_container = document.querySelector('#input_email_container');
        console.log(input_email_container);
        if (input_email_container.value == "") {
            document.querySelector('#email_container .input-error').innerHTML = "El correo es obligatorio";
            canSubmit = false;
        }
        else {
            var indexOne = input_email_container.value.indexOf("@");
            var indexTwo = input_email_container.value.indexOf(".");
            if (indexOne < 0 || indexTwo < 0) {
                document.querySelector('#email_container .input-error').innerHTML = "El correo no tiene el formato";
                canSubmit = false;
            }
            else {
                document.querySelector('#email_container .input-error').innerHTML = "";
            }

            //-----------

        }
        //contraseña
        var input_pass_container = document.querySelector('#password');
        console.log(input_pass_container);
        if (input_pass_container.value == "") {
            document.querySelector('#password_container .input-error').innerHTML = "La contraseña es obligatoria";
            canSubmit = false;
        }
        else {
            document.querySelector('#password_container .input-error').innerHTML = "";
        }


        if (!canSubmit) {
            event.preventDefault();
        }

    })
})