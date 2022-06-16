package pichincha.com.maaseichaq.Entidad;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private String email_usuario;
    private String contrasenia_usuario;
    private Integer edad_usuario;
    private String estado_usuario;
    private String options;

    public Usuario(){
        super();
    }

    public Usuario(String nombre_usuario, String apellido_usuario, String email_usuario, String contrasenia_usuario, Integer edad_usuario, String estado_usuario) {
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.email_usuario = email_usuario;
        this.contrasenia_usuario = contrasenia_usuario;
        this.edad_usuario = edad_usuario;
        this.estado_usuario = estado_usuario;
    }
    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getContrasenia_usuario() {
        return contrasenia_usuario;
    }

    public void setContrasenia_usuario(String contrasenia_usuario) {
        this.contrasenia_usuario = contrasenia_usuario;
    }

    public Integer getEdad_usuario() {
        return edad_usuario;
    }

    public void setEdad_usuario(Integer edad_usuario) {
        this.edad_usuario = edad_usuario;
    }

    public String getEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(String estado_usuario) {
        this.estado_usuario = estado_usuario;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
