
  window.addEventListener('DOMContentLoaded', function(event){
    var form_register = document.querySelector('#form-register');
    form_register.addEventListener('submit', function(event){
        //event.preventDefault();
        var canSubmit= true;
        var input_last_name= document.querySelector('#contrasena');
        if(input_last_name.value == ""){
            document.querySelector('#last_name_container .input-error').innerHTML = 'La contraseña es obligatorio';
            canSubmit = false;
        }else{
            if (input_last_name.value.length < 12){
                document.querySelector('#last_name_container .input-error').innerHTML = 'La contraseña debe tener al menos 12 caracteres';
                canSubmit = false;    
                }else {
                    document.querySelector('#last_name_container .input-error').innerHTML = '';
                }
        }
        var input_email= document.querySelector('#input_email');
        if(input_email.value == ""){
            document.querySelector('#email_container .input-error').innerHTML = 'El email es obligatorio';
            canSubmit = false;
        }else{
            var indexOne = input_email.value.indexOf("@");
            var indexTwo = input_email.value.indexOf(".");
            if (indexOne < 0 || indexTwo < 0){
                document.querySelector('#email_container .input-error').innerHTML = 'El correo electronico no es correcto';
                canSubmit = false;
            } else {
                document.querySelector('#email_container .input-error').innerHTML = '';
            }
        }
        if(!canSubmit){
            event.preventDefault();
        }
        
    })

    const fetchData = async () => {
      var response = await fetch('https://localhost:7098/api/Usuarios');
      var json = await response.json();
      console.log(json)
      return json;
  }
  async function validarCampos(){
      var json = await fetchData();
      var email =document.getElementById("input_email").value;
      var contrasena =document.getElementById("contrasena").value;
      ////vale
      for (let index = 0; index < json.length; index++) {
          const element = json[index];
          var correo=element.emailUsuario;
          if(email ==correo){
              alert("Ingreso Correcto")
              window.location="Bienvenido.html";
      
          }else{
              alert("Ingreso incorrecto")
              window.location="index.html";
      
          }
      }
  }
});
  
/*
const fetchData = async () => {
  var resp = await fetch('https://localhost:7098/api/Usuarios');
  var json = await resp.json();
  return json;
  
}



window.addEventListener('DOMContentLoaded', function(event){
setTodoList();
});*/
