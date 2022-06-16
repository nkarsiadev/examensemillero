package com.pichincha.backTest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pichincha.backTest.repository.UsuarioService;
import com.pichincha.backTest.entity.Usuario;
import com.pichincha.backTest.exception.ResourceNotFoundException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioServices;
	
	//Listar Usuarios
	@GetMapping("listar")
	public List<Usuario> getUsuarios(){
		return this.usuarioServices.findAll();
	}
	
	//Buscar Usuario por id
	@GetMapping("search/{id}")
	public Usuario getUsuarioId(@PathVariable (value = "id") long id_usuario) {
		return this.usuarioServices.findById(id_usuario).orElseThrow(()->new ResourceNotFoundException("Usuario no encontrado:"+id_usuario));
	} 
	
	@PostMapping("post")
	public Usuario createUsuario(@RequestBody Usuario user) {
		return this.usuarioServices.save(user);
	}
	
	@PutMapping("put/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable (value = "id") long id_usuario, @RequestBody Usuario user) throws ResourceNotFoundException {
		Usuario userD = this.usuarioServices.findById(id_usuario).orElseThrow(()->new ResourceNotFoundException("Usuario no encontrado:"+id_usuario));
		userD.setCi_usuario(user.getCi_usuario());
		userD.setCorreo(user.getCorreo());
		userD.setPwd(user.getPwd());
		return  ResponseEntity.ok(this.usuarioServices.save(userD));
	}
	
	@DeleteMapping("del/{id}")
	public Map<String, Boolean> deleteUsuario(@PathVariable ("id") long id_usuario){
		Usuario exist = this.usuarioServices.findById(id_usuario).orElseThrow(()->new ResourceNotFoundException("Usuario no encontrado:"+id_usuario));
		this.usuarioServices.delete(exist);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Se elimino el Productor", Boolean.TRUE);
		return response;
	}
	
}
