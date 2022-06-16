package com.by.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user2")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	
	private String nameUser;
	private String lastNameUser;
	private String emailUser;
	private String passwordUser;
	private int ageUser;
	private String statusUser;
	private int idRoleUser;
	
	
	public User(Long idUser, String nameUser, String lastNameUser, String emailUser, String passwordUser, int ageUser,
			String statusUser, int idRoleUser) {
		super();
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.lastNameUser = lastNameUser;
		this.emailUser = emailUser;
		this.passwordUser = passwordUser;
		this.ageUser = ageUser;
		this.statusUser = statusUser;
		this.idRoleUser = idRoleUser;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getIdUser() {
		return idUser;
	}


	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


	public String getNameUser() {
		return nameUser;
	}


	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}


	public String getLastNameUser() {
		return lastNameUser;
	}


	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}


	public String getEmailUser() {
		return emailUser;
	}


	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}


	public String getPasswordUser() {
		return passwordUser;
	}


	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}


	public int getAgeUser() {
		return ageUser;
	}


	public void setAgeUser(int ageUser) {
		this.ageUser = ageUser;
	}


	public String getStatusUser() {
		return statusUser;
	}


	public void setStatusUser(String statusUser) {
		this.statusUser = statusUser;
	}


	public int getIdRoleUser() {
		return idRoleUser;
	}


	public void setIdRoleUser(int idRoleUser) {
		this.idRoleUser = idRoleUser;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
