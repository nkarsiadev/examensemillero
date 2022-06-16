// package io.github.jiangdequan;
package pruebaBP.pruebaBP.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario{

    @Id
    @Column(name="usuario") // columna en la base de datos
    private String usuario;
    
    @Column(name="contrasena")  // columna en la base de datos
    private String contrasena;

    public Usuario ( String usuario, String contrasena){
        this.usuario = usuario;
        this.contrasena=contrasena;
    }

    public Usuario(){

    }   

    /**
     * @return String return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return String return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}