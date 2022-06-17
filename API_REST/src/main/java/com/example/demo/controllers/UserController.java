package com.example.demo.controllers;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.UserModel;
import com.example.demo.services.*;

@RestController

@RequestMapping("/users_login")
@CrossOrigin(origins = "*")
public class UserController implements IUserController{
    @Autowired
    UserServices userServices;

    @Override
    @PostMapping("/Guardar")
    public UserModel GuardarUser(@RequestBody UserModel usuario){
        return this.userServices.GuardarUser(usuario);
    }

    @Override
    @GetMapping()
    public ArrayList<UserModel> TodosUsers(){
        return userServices.TodosUsers();
    }

    @Override
    @GetMapping(path = "/validarUser/{user}")
    public String ValidarUseryPass(@PathVariable("user") String user) {
        // TODO Auto-generated method stub
        boolean aux = userServices.ValidarUseryPass(user);
        if (aux==true) {
            return "No existe Usuario";
        }else if(aux==false){
            return "Existe";
        }else{
            return "No se valida";
        }
    }

    @Override
    @GetMapping(path = "/validarcredenciales/{password}")
    public String ValidarCredenciales(@PathVariable("user") String password) {
        // TODO Auto-generated method stub
        boolean aux = userServices.ValidarPass(password);
        if (aux==true) {
            return "No existe Usuario";
        }else if(aux==false){
            return "Existe";
        }else{
            return "No se valida";
        }
    }

    @Override
    @GetMapping(path="/usuario/{user}")
    public ArrayList<UserModel> BuscarUser(@PathVariable("user") String user) {
        // TODO Auto-generated method stub
        return this.userServices.BuscarUsuario(user);
    }

    @Override
    @GetMapping(path="/BuscarID/{ID}")
    public Optional<UserModel> BuscarXId(@PathVariable("ID") Long ID){
        return this.userServices.BuscarXId(ID);
    }

    @Override
    @GetMapping(path="/password/{password}")
    public ArrayList<UserModel> BuscarContrasena(@PathVariable("password") String password) {
        // TODO Auto-generated method stub
        return this.userServices.BuscarContrasena(password);
    }
}
