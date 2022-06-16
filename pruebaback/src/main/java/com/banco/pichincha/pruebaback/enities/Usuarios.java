package com.banco.pichincha.pruebaback.enities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // genera automaticamente el id incrementalmente
    private Long idUsuario;

    private String nameUsuario;
    private String lastNameUsuario;
    private String emailUsuario;
    private String passwordUsuario;
    private int edadUsuarios;
    private String status;

    @ManyToOne
    @JoinColumn(name = "idRol") // apunto a la tabla Roles, para definir la relacion de usuario y su rol
    private Roles rol;// crear un atributo de tipo Roles, para generar el json adecuado

    // constructor basico o vacio
    public Usuarios() {

    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNameUsuario() {
        return nameUsuario;
    }

    public void setNameUsuario(String nameUsuario) {
        this.nameUsuario = nameUsuario;
    }

    public String getLastNameUsuario() {
        return lastNameUsuario;
    }

    public void setLastNameUsuario(String lastNameUsuario) {
        this.lastNameUsuario = lastNameUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public int getEdadUsuarios() {
        return edadUsuarios;
    }

    public void setEdadUsuarios(int edadUsuarios) {
        this.edadUsuarios = edadUsuarios;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

}
