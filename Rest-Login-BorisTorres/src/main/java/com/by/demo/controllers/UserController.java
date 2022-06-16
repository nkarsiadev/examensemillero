package com.by.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.by.demo.exception.UsuarioServiceNullException;
import com.by.demo.models.User;
import com.by.demo.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService uService;
	
	@GetMapping("/list")
	public ResponseEntity<List<User>> listUsers() throws UsuarioServiceNullException{
		return ResponseEntity.status(HttpStatus.OK).body(uService.listUsers());
	}
	

	@GetMapping("/list/{emailUser}")
	public ResponseEntity<User> listEmail(@RequestParam("emailUser") String emailUser){
		User userL = uService.getEmailUser(emailUser);
		if(userL == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<User>(userL,HttpStatus.OK);
		}
	}
	
	
	
	@PostMapping("/create")
	public ResponseEntity<String> createUsuario(@RequestBody User u) throws UsuarioServiceNullException{
		User userCreated = uService.createUser(u);
		if(userCreated == null) {
			return new ResponseEntity<String>("Error en ingreso de datos", HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			
			return new ResponseEntity<String>("Usuario Creado", HttpStatus.CREATED);
		}
	}
	
	
	
	

}
