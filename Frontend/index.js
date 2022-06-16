const URL_API = 'https://localhost:7140/api/Users/';

const fetchData = async() => {
    let email = document.querySelector('#email').value;
    let password = document.querySelector("#password").value;

    if(validation()){
        if(email!=""){
            let response = await fetch(URL_API+ email);
            let json =  await response.json();
            
            if(json.respuesta != "1"){
                alert('The email is not registered!')
                document.querySelector('#email').value="";
                document.querySelector("#password").value="";
            }
            else{
                let response = await fetch(URL_API + email + "/" + password);
                let json = await response.json();
                
                alert(json.respuesta);
                if(json.respuesta!="Invalid email/password!"){
                    location.href = "view.html?dist=" + email;
                }
                document.querySelector('#email').value="";
                document.querySelector("#password").value="";
            }
        }
    }

    
    // return json;
}

function validation(){
    event.preventDefault();
    var canSubmit = true;

    //validation email
        var input_email = document.querySelector('#email');
        if(input_email.value==""){
            document.querySelector('.input-error-email').innerHTML = 'Email is required!';
            canSubmit = false;
        }else{
            var indexOne = input_email.value.indexOf("@");
            var indexTwo = input_email.value.indexOf(".");
            console.log(indexOne);
            console.log(indexTwo);
            if(indexOne < 0 || indexTwo < 0){
                document.querySelector('.input-error-email').innerHTML = 'Please enter a valid email!';
                canSubmit = false;
            }else if(indexTwo < indexOne){
                document.querySelector('.input-error-email').innerHTML = 'Please enter a valid email!';
                canSubmit = false;
            }
            else{
                document.querySelector('.input-error-email').innerHTML = '';
            }
        }

        //validation password
        var input_password = document.querySelector("#password");
        if(input_password.value==""){
            document.querySelector('.input-error').innerHTML = 'Password is required!';
            canSubmit = false;
        }
    return canSubmit;
}

window.addEventListener('DOMContentLoaded', function(event){
    event.preventDefault();
    setTodoList();
})

const setTodoList = async() =>{
    let res = await fetch('https://localhost:7140/api/Users');
    let json = await res.json();

    var element_container = document.querySelector("table");
    // element_container.innerHTML = '';
    
    json.forEach(element => {
        element_container.innerHTML +=  `<tr>
        <td>${element.name}</td>
        <td>${element.lastName}</td>
        <td>${element.email}</td>
        <td>${element.age}</td>
        <td>${element.status}</td>
        <td>${element.rol}</td>
        </tr>`;
    });
    
    
}
