package com.pichincha.backTest.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private long id_usuario;
	
	@Column(name="ci_usuario")
	private String ci_usuario;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="pwd")
	private String pwd;
	
//	@OneToMany(mappedBy= "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private Set<Cuenta> cuentas;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String ci_usuario, String correo, String pwd) {
		super();
		this.ci_usuario = ci_usuario;
		this.correo = correo;
		this.pwd =pwd;
//		this.cuentas = cuentas;
	}
	
//	public Set<Cuenta> getCuentas() {
//		return cuentas;
//	}
//
//	public void setCuentas(Set<Cuenta> cuentas) {
//		this.cuentas = cuentas;
//	}

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getCi_usuario() {
		return ci_usuario;
	}

	public void setCi_usuario(String ci_usuario) {
		this.ci_usuario = ci_usuario;
	}

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

	
	
}
