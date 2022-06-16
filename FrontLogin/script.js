//const API_URL = 'https://localhost:7090/api/usuario';
//axios.get('https://localhost:7090/api/usuario').then(response=>console.log(response));
const API_URL = 'https://localhost:7090/api/usuario';


const paramRequest ={    
}
//recuperacion de datos por medio de axios 
let loginn;
let loginpass;
axios.get(API_URL,{
    
}).then(response =>{
    console.log(response.data);
    var usuario = document.getElementById('usuario');
    // usuario.innerHTML="";
    // var html=``;
    response.data.forEach(element => {
        loginn = `${element.email_user}`
        console.log(loginn);
        loginpass= `${element.password_user}`
        console.log(loginpass);     
           
    });

})


//funcion para el boton que pueda ingresar a la siguiente pantalla 
function login(){
    var user, pass;

    user = document.getElementById("login-name").value;
    pass = document.getElementById("login-pass").value;
    if(user == "Ri" && pass == "123" ){
        window.location ="usuario.html"; 
    }
    if(user == loginn && pass == loginpass){
        window.location ="usuario.html"; 
        alert("Login Success");
    }      
}