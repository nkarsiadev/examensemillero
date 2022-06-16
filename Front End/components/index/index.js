const fetchData = async() => {
    var response = await fetch ('https://localhost:7057/api/Usuario');
    var json = await response.json();
    console.log(json);
    return json;
}

window.addEventListener('DOMContentLoaded', function(event){
    var form_login = document.querySelector('#form-login');
    form_login.addEventListener('submit', function(event){
        var canSubmit = true;
        var input_user = document.querySelector('#input-user');
        if (input_user.value==''){
            document.querySelector('#conteiner_user .input-error').innerHTML = "El usuario es obligatorio";
            canSubmit = false;
        } else{
            if(input_user.value.length < 3){
                document.querySelector('#conteiner_user .input-error').innerHTML = "El usuario debe tener al nmenos 3 caracteres";
                canSubmit = false;
            }else{
                document.querySelector('#conteiner_user .input-error').innerHTML = '';
            }    
        }
        var input_password = document.querySelector('#input-password');
        if (input_password.value==''){
            document.querySelector('#conteiner_password .input-error').innerHTML = "La contraseña es obligatoria";
            canSubmit = false;
        } else{
            if(input_password.value.length < 3){
                document.querySelector('#conteiner_password .input-error').innerHTML = "La contraseña debe tener al menos 8 caracteres";
                canSubmit = false;
            }else{
                document.querySelector('#conteiner_password .input-error').innerHTML = '';
            }    
        }

       

        if (!canSubmit){
            event.preventDefault();
        }
    })
})