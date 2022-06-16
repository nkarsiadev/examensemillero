const fetchData = async () => {
    var response = await fetch('https://localhost:7011/api/usuarios');
    var json = await response.json();
    console.log(json)
    return json;
}
async function validar(){
    var json = await fetchData();
    var email =document.getElementById("emailUsuario").value;
    var contrasena =document.getElementById("contrasenaUsuario").value;
    ////vale
    for (let index = 0; index < json.length; index++) {
        const element = json[index];
        var correo=element.emailUsuario;
        var contra=element.contrasenaUsuario;
        if(email ==correo&& contrasena==contra){
            alert("Usuario correcto")
            window.location="home.html";
    
        }else{
            alert("Usuario incorrecto")
            window.location="index.html";
    
        }
    }
    
}