package com.by.demo.interfaceServices;

import java.util.List;
import java.util.Optional;

import com.by.demo.exception.UsuarioServiceNullException;
import com.by.demo.models.User;

public interface IUserService {
	
	public List<User>listUsers() throws UsuarioServiceNullException; 
	
	public User createUser(User u) throws UsuarioServiceNullException;
	
	public void deleteUser(Long idUser) throws UsuarioServiceNullException;
	
	//public Optional<User> listForEmail(String email) throws UsuarioServiceNullException;

}
