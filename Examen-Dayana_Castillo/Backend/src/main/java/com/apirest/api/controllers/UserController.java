package com.apirest.api.controllers;

import java.util.ArrayList;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.apirest.api.models.UserModel;
import com.apirest.api.services.*;

@RestController // etiqueta q va a decir spring q es su funcion
@RequestMapping("/usuario") // en q dirrecion del servidor se va activar los metodos de esta clase
public class UserController {
    @Autowired // sirve para instanciar directamente por spring
    UserServices userServices;

    @CrossOrigin
    @GetMapping() // indica q cuando llega una peticion de tipo get desde el navegador ejecute
                  // este flujo
    public ArrayList<UserModel> obtUsers() {
        return userServices.obtUsers();
    }

    @CrossOrigin
    @PostMapping // regresar el usuario con el id
    public UserModel SaveUser(@RequestBody UserModel usuario) {// el request body es es el envío de un mensaje de //
                                                               // una aplicación cliente a otra aplicación servidora
        return this.userServices.SaveUser(usuario);
    }

    /*
     * @GetMapping(path = "/{id}")
     * public Optional<UserModel> obtUsersPorId(@PathVariable("id") Long id) {
     * return this.userServices.obtenerPorId(id);
     * }
     * 
     * @GetMapping("/query")
     * public ArrayList<UserModel> obtUsersPorPrioridad(@RequestParam("prioridad")
     * Integer prioridad) {
     * return this.userServices.obtenerPorPrioridad(prioridad);
     * }
     * 
     * @DeleteMapping(path = "/{id}")
     * public String eliminarPorId(@PathVariable("id") Long id) {
     * boolean ok = this.userServices.eliminarUsuario(id);
     * if (ok) {
     * return "Se eliminó el usuario con id " + id;
     * } else {
     * return "No pudo eliminar el usuario con id" + id;
     * }
     * }
     */

}
