package com.prueba.apibackend.controllers;

import com.prueba.apibackend.models.UserModel;
import com.prueba.apibackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/login")
public class UserController {
    @Autowired
    UserService userService;

    //Obtener Lista Usuarios
    @GetMapping(path = "/users")
    public ArrayList<UserModel> getUsers(){
        return userService.getUsers();
    }
   @GetMapping
    public ArrayList<UserModel> obtenerPorEmail(@RequestParam("user_email") String user_email){
        return this.userService.obtenerPorEmail(user_email);
    }

}
