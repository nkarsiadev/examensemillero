# examensemillero
# **Proyecto Back-end**
![GitHub repo size](https://img.shields.io/github/repo-size/alex-vinicio/backtarea)
<picture>

  <img style="width:150px" alt="Shows an illustrated sun in light color mode and a moon with stars in dark color mode." src="https://cdn-icons-png.flaticon.com/512/226/226777.png">
</picture>

## **Descripcion**
Es este examen semillero el cual esta enfocado Back-end para API y font-end par ael consumo.
> Se enfoca en la creacion de una API Rest de gestion (CRUD) de Usuarios y rol.

## Tecnologicas
- [Javas](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
    - JDK 11
- [PostgreSQL](https://www.postgresql.org/download/)
    - pgAdmin 4 v6
- [Spring boot](https://start.spring.io/)
    - JPA
    - Hibernate = Update
    - Argon2 2.5
- Maven
    - 2.7
## Propiedades

```properties
Puerto server: 8085 -> localhost:8085
````
#### Configuracion en application.properties para la Base de datos
```properties
#codigo anterior
spring.datasource.username={tu nombre de usuario} -> ....username=posgres

spring.datasource.password={tu contra..}  -> ....password=1234

spring.datasource.url=jdbc:postgresql://localhost:{puertoPostres}/{nombre de la BD}?useSSL=false -> 
....url=jdbc:postgresql://localhost:5432/semillero_prueba_aa?useSSL=false
#codigo siguiente
```
## **Estructura del proyecto**
- Arquitectura en Ncapas - MVC
  - Capa Controllers.
  - Capa Entity.
  - Capa Service - Injeccion de dependencias.
  - Capa Repository.
  - Capa Exceptions.

# **Proyecto Back-end**
Utilizar el proyecto Front para consumir las APIS de back-end.
- validaciones
  - Control por formulario de campos llenos.
  - Si el Back responde con usuario correcto, guarda la informacion de session en LocalStorage.
  - unicamente accede a listar con valores en localStorage, sino no permite acceso.
  - Utilizar ``` Go Live ``` para levantar el front.
##Paths para el login
Acceder al index general con ```http://{tu ip o localhost}:{el puerto donde se levanto}/src/index.html ```
- http://127.0.0.1:5500/src/   para acceder al index.html
- http://127.0.0.1:5500/src/listar.html  para acceder al listado
### **Otros detalles**
![YouTube Channel Views](https://img.shields.io/youtube/channel/views/UCxjuoksUCWEE91mUNnzk4CA?style=social)
![GitHub](https://img.shields.io/github/license/alex-vinicio/backtarea)
