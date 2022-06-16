package com.banco.pichincha.pruebaback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.pichincha.pruebaback.enities.Usuarios;
import com.banco.pichincha.pruebaback.service.UsuariosServiceI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/semillero")
public class UsuariosController {

    @Autowired
    private UsuariosServiceI usuariosService;

    @GetMapping(value = "/usuarios")
    public ResponseEntity<List<Usuarios>> getAllUsuarios() {
        List<Usuarios> listaUsuarios = usuariosService.getAllUsuarios();
        if (listaUsuarios != null) {
            return new ResponseEntity<List<Usuarios>>(listaUsuarios, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Usuarios>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/usuarios/name")
    public ResponseEntity<Usuarios> getByUserNameExist(@RequestParam("name") String name) {
        Usuarios usuario = usuariosService.getUsuarioName(name);
        if (usuario != null) {
            return new ResponseEntity<Usuarios>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<Usuarios>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/usuarios/mail")
    public ResponseEntity<Usuarios> getByEmailOfUser(@RequestParam("mail") String mail) {
        Usuarios usuario = usuariosService.getUsuarioEmail(mail);
        if (usuario != null) {
            return new ResponseEntity<Usuarios>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<Usuarios>(HttpStatus.NOT_FOUND);
        }
    }
}
