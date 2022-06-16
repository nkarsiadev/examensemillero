package com.example.demo.controllers;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @CrossOrigin
    @GetMapping
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }
    @CrossOrigin
    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @CrossOrigin
    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obteneUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @CrossOrigin
    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorEmail(@RequestParam("email_usuario") String email){
        return this.usuarioService.obtenerPorEmail(email);
    }
}
