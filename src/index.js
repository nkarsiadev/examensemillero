const fethData = async() => {
    var path = "http:/localhost:8080/users_login/"
    var response = await fetch(path);
    var json = await response.json();
    return json;
}
const setTodoList = async() => {
    var json = await fethData();
    var boton = document.getElementById("button");
    boton.addEventListener("click",function(e){
        var elementos=json;
        var Usuario = document.getElementById("input-Usuario").value;
        var Contraseña = document.getElementById("input-pass").value;
        if (Usuario=="") {
            console.log("Debe estar lleno usuario")
        }else{
            var aux=false;
            for (let index = 0; index < json.length; index++) {
                const element = json[index];
                if (element.user==Usuario) {
                    aux = true;
                }
            }
            console.log(aux);
            if (aux==true) {
                console.log("Usuario verificado")
            }else{
                console.log("No existe usuario")
            }
        }

        if (Contraseña=="") {
            console.log("Debe estar lleno contraseña")
        }else{
            var aux=false;
            for (let index = 0; index < json.length; index++) {
                const element = json[index];
                console.log(element.password)
                if (element.password==Contraseña) {
                    aux = true;
                }
            }
            console.log(aux);
            if (aux==true) {
                console.log("Contraseña Verificada verificado")
            }else{
                
            }
        }
        
    })

   console.log(json[0].user);
}

window.addEventListener("DOMContentLoaded", function(e){
    setTodoList();
    
})