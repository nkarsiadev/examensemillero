
let peliculas='';
const apiURL = "https://bp-marvel-api.herokuapp.com/marvel-characters?idAuthor=1"
//Ver listado 
axios.get("http://localhost:8081/api/user/list/")
    .then((response)=>{
        console.log(response.data);

        //publicar en html
        response.data.forEach(element => {
            //let elemento_id = element._id;
        peliculas  += ` 
        <table border="1px">
                            <tr>
                              <td><strong>id</strong></td>
                              <td><strong>Nombre</strong></td>
                              <td><strong>Apellido</strong></td>
                              <td><strong>Email</strong></td>
                              <td><strong>Role</strong></td>
                              <td><strong>Status</strong></td>
                              
                            </tr>
                            
                            <tr>
                              <td>${element.idUser}</td>
                              <td>${element.nameUser}</td>
                              <td>${element.lastNameUser}</td>
                              <td>${element.emailUser}</td>
                              <td>${element.idRoleUser}</td>
                              <td>${element.statusUser}</td>
                            </tr>
                            
                            
                            </table>
        `;
        
        
    });
    document.getElementById('contenedor').innerHTML = peliculas;
    })
    .catch((error)=>{
        console.log("Mal conectado el api"+error);
    })


//preventDefault
window.addEventListener('DOMContentLoaded', function(event){
    
    var form_register = document.querySelector('#form-register');

    //nombre
    form_register.addEventListener('submit', function (event){ 

        var canSubmit = true;
        var input_name = document.querySelector('#input_name');

        if(input_name.value == ""){
            document.querySelector('#name_container .input-error').innerHTML = 'El nombre es obligatorio';
            canSubmit = false;
        } else {
            if(input_name.value.length < 3){
                document.querySelector('#name_container .input-error').innerHTML = "El nombre debe tener mas de 3 caracteres";
                canSubmit = false;
        }else{
                document.querySelector('#name_container .input-error').innerHTML = "";
            }
        }

        //email

        var input_email = document.querySelector('#input_email');

        if(input_email.value == ""){
            document.querySelector('#email_container .input-error').innerHTML = 'El correo electrónico es obligatorio';
            canSubmit = false;
        } else {

            var indexOne = input_email.value.indexOf("@");
            var indexTwo = input_email.value.indexOf(".");

            if(indexOne < 0 || indexTwo < 0){
                document.querySelector('#email_container .input-error').innerHTML = "El correo debe tener @ y un dominio";
                canSubmit = false;
        }else{
                document.querySelector('#email_container .input-error').innerHTML = "";
            }
        }


        if(!canSubmit){
            event.preventDefault();
        }

    })
    
})

