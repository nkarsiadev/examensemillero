const apiURL = "http://localhost:8090/";

const axiosAllUsers = () =>  axios.get(apiURL + "users/")
    .then(response => {
        return response;
    })


window.addEventListener("DOMContentLoaded", async function (event){
    let json = await axiosAllUsers();
    if (json?.data){
        let itemUSer = this.document.getElementById("itemuser")
        itemUSer.innerHTML = `
        <tr>
            <td>Nombre</td>
            <td>Correo</td>
            <td>Edad</td>
            <td>Estatus</td>
        </tr>
        `
        for (let index = 0; index < json.data.length; index++) {
            itemUSer.innerHTML += `
            <tr>
                <td>${json.data[index].name}</td>
                <td>${json.data[index].email}</td>
                <td>${json.data[index].age}</td>
                <td>${json.data[index].status}</td>
            </tr>
            `
        }
    }
})