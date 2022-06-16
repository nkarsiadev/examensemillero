const url_base_usuario = "http://192.168.1.5:8080/usuario/";

document.addEventListener('DOMContentLoaded', function(){
    document.querySelector('#mensajeBienvenida').innerHTML = `Bienvenido ${sessionStorage.getItem('user')}`;
    axios.get(`${url_base_usuario}listar`).then(function(response){
        let users = response.data;
        let userHtml = document.querySelector("#datosUsuario");
        userHtml.innerHTML = '';
        for (let i = 0; i < users.length; i++) {
            userHtml += `<tr><td>${users[i].nombre_usuario}</td>
            <td>${users[i].apellido_usuario}</td>
            <td>${users[i].email_usuario}</td>
            <td>${users[i].edad_usuario}</td>
            <td>${users[i].estado_usuario}</td>
            <td>${users[i].options}</td></tr>`;
        }
        document.querySelector("#datosUsuario").innerHTML = userHtml;
    }).catch(function (err) {
        alert(err.response.data);
    });
});

function fntDelInfo(id){
    if(confirm("¿Esta seguro de eliminar al usuario?")){
        axios.delete(`${url_base_usuario}del/${id}`).then(function (response) {
            alert("Usuario Eliminado");
            location.reload();
        }).catch(function (err) {
            alert(err.response.data);
        });
    }
}

function fntEditInfo(id){
    document.querySelector('.modal-header').classList.replace("headerRegister", "headerUpdate");
    document.querySelector('#btnActionForm').classList.replace("btn-success", "btn-info");
    document.querySelector('#btnText').innerHTML ="Actualizar";
    document.querySelector('#titleModal').innerHTML = "Actualizar Usuario";
    document.querySelector("#formUsuario").reset();
    axios.get(`${url_base_usuario}buscar/${id}`).then(function(response) {
        document.querySelector('#idUsuario').value = response.data.id_usuario;
        document.querySelector('#txtNombre').value = response.data.nombre;
        document.querySelector('#txtApellido').value = response.data.apellido;
        document.querySelector('#txtEmail').value = response.data.email;
    }).catch(function (err) {
        alert(err.response.data);
      });
}

function openModal(){
    document.querySelector('#idUsuario').value ="";
    document.querySelector('.modal-header').classList.replace("headerUpdate", "headerRegister");
    document.querySelector('#btnActionForm').classList.replace("btn-info", "btn-success");
    document.querySelector('#btnText').innerHTML ="Guardar";
    document.querySelector('#titleModal').innerHTML = "Nuevo Usuario";
    document.querySelector("#formUsuario").reset();
}