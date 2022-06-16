package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_usuario;
    private String name_usuario;
    private String last_name_usuario;
    private String email_usuario;
    private String password_usuario;
    private Integer edad_usuario;
    private String status;

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getName_usuario() {
        return name_usuario;
    }

    public void setName_usuario(String name_usuario) {
        this.name_usuario = name_usuario;
    }

    public String getLast_name_usuario() {
        return last_name_usuario;
    }

    public void setLast_name_usuario(String last_name_usuario) {
        this.last_name_usuario = last_name_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getPassword_usuario() {
        return password_usuario;
    }

    public void setPassword_usuario(String password_usuario) {
        this.password_usuario = password_usuario;
    }

    public Integer getEdad_usuario() {
        return edad_usuario;
    }

    public void setEdad_usuario(Integer edad_usuario) {
        this.edad_usuario = edad_usuario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
