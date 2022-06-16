package com.apirest.api.models;

import javax.persistence.*; /*esta biblioteca ayuda a importr todas las anpotaciones de jpa */

@Entity /* con esto decimos q es un modelo real */
@Table(name = "usuario") /* para llamar al nombre de la tabla */
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*
                                                         * es un id q se genera automaticamente es unico y no pued *
                                                         * nulo
                                                         */
    private Long id;
    private Integer edad;
    private String nombre;
    private String email;
    private String password;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
