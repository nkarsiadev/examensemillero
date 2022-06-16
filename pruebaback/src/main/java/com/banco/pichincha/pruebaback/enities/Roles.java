package com.banco.pichincha.pruebaback.enities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // genera automaticamente el id incrementalmente
    private Long idRol;

    private String nameRol;
    private String statusRol;

    public Roles() {
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNameRol() {
        return nameRol;
    }

    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }

    public String getStatusRol() {
        return statusRol;
    }

    public void setStatusRol(String statusRol) {
        this.statusRol = statusRol;
    }

}
