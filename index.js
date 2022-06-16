const fetchData = async () => {
    var response = await fetch('http://localhost:8000/api/listar');
    console.log(response);
    var json = await response.json();
    console.log(json);
    return json;

}
/* ci_usuario": "1722555800",
        "nombre": "Gaby",
        "apellido */


async function setTodoList() {
    var json = await fetchData();
    var input_name = document.querySelector('#input_email');
    console.log("este es el correo", input_name);
  /*   var element_container = document.querySelector('.container-list');
    element_container.innerHTML = '';
 */
    for (let index = 0; index < json.length; index++) {
        const element = json[index];
        var e = element.correo;
        console.log("este es el correo", e);
        if (input_name.value == e) {
            console.log(input_name.value);
            window.location = "usuarios.html";
           /*  element_container.innerHTML += ` <div class="item-element-content">
                    <h2>${element.nombre}</h2>
                </div>
            ` */
        } else {
            console.log("error");
           /*  element_container.innerHTML += `  <div class="item-element-content">
                        <h2>usuario y contraseña incorrecto</h2>
                    </div>
                ` */
        }

        ;


    }


}
