package com.examen.loginApi.controller;

import com.examen.loginApi.persistence.entitys.User;
import com.examen.loginApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users/")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        System.out.println("Controller");
        return userService.getAllUsers();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "{email}/{password}")
    public ResponseEntity<User> getUserLogin(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.getUserLogin(email, password);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email){
        return userService.findByEmail(email);
    }
}
