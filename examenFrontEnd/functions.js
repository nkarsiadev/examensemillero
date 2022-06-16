const url_base_usuario = "http://192.168.1.5:8080/usuario/";

function ingresar(){
    let email = document.getElementById('txtEmailUsuario').value;
    let pass = document.getElementById('txtPasswordUsuario').value;
    axios.get(`${url_base_usuario}${email}/${pass}`).then(function(response) {
        sessionStorage.setItem('user', response.data.nombre_usuario+" "+response.data.apellido_usuario);
        window.location.replace("/Inicio/bienvenida.html");      
    }).catch(function (err) {
        alert(err.response.data);
      });
}