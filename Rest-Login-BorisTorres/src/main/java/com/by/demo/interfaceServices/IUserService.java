package com.by.demo.interfaceServices;

import java.util.List;

import com.by.demo.exception.UsuarioServiceNullException;
import com.by.demo.models.User;

public interface IUserService {
	
	
	public List<User>listUsers() throws UsuarioServiceNullException; 
	
	public User createUser(User u) throws UsuarioServiceNullException;
	
	public User getUSerName(String nameUser);
	
	public User getEmailUser(String emailUser);

    //public User verifyUserByEmailndPassword(String emailUser, String passwordUser);
	
	//public Optional<User> listForEmail(String email) throws UsuarioServiceNullException;

}
