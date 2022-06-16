package com.by.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.by.demo.exception.UsuarioServiceNullException;
import com.by.demo.interfaceServices.IUserService;
import com.by.demo.interfaces.IUser;
import com.by.demo.models.User;


@Service
public class UserService implements IUserService {

	@Autowired
	IUser iUser;
	
	@Override
	public List<User> listUsers() throws UsuarioServiceNullException {
		List<User> usersList = (List<User>) iUser.findAll();
		try {
			if(usersList.size()>0) {
				return usersList;
			}else {
				throw new UsuarioServiceNullException("No hay lista de usuario");
			}
		}
		catch(UsuarioServiceNullException e) {
			throw new UsuarioServiceNullException("Error en la consulta de usurios");
		}
	}
	
	/*
	@Override
	public Optional<User> listForEmail(String email) throws UsuarioServiceNullException {
		try {
			if(iUser.existByEmail(email)) {
				return iUser.findByEmailUser(email);
			}else {
				throw new UsuarioServiceNullException("No existe el correo " +iUser.findByEmailUser(email));
			}
		}
		catch(UsuarioServiceNullException e) {
			throw new UsuarioServiceNullException("Error en correo");
		}
	
	}
	*/

	@Override
	public User createUser(User u) throws UsuarioServiceNullException {
		Optional<User> userRepetido = iUser.findByEmailUser(u.getEmailUser());
		try {
			if(userRepetido.isPresent()) {
				throw new UsuarioServiceNullException("EL correo electronico ya existe: "+ u.getEmailUser());
			}else {
				User usuarioCrear = iUser.save(u);
				return usuarioCrear;
			}
			
		}catch(Exception e) {
			//e.printStackTrace();
			throw new UsuarioServiceNullException("El correo electronico se encuentra registrado " +u.getEmailUser() );
		}
	}

	@Override
	public void deleteUser(Long idUser) throws UsuarioServiceNullException {
		try {
			iUser.deleteById(idUser);
		}catch(Exception e) {
			throw new UsuarioServiceNullException("Error al borrar el usuario " +idUser);
		}
		
	}

	

	

}
