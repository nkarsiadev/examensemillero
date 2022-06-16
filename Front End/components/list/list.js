const fetchData = async() => {
    var response = await fetch ('https://localhost:7057/api/Usuario');
    var json = await response.json();
    console.log(json);
    return json;
}

const listUsers = async() => {
    var json = await fetchData();
    var conteiner = document.querySelector('.conteiner');
    conteiner.innerHTML='';
    for (let index = 0; index < json.length; index++) {
        const element = json[index];
        conteiner.innerHTML+=`
        <tr >
        <th scope="row">${element.idUsuario}</th>
        <td>${element.nombreUsuario}</td>
        <td>${element.contraseniaUsuario}</td>
        </tr>
            
        `
    }
}

window.addEventListener('DOMContentLoaded', function(event){
    listUsers();
})