package com.example.demo.controllers;
import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UserModel;

public abstract interface IUserController {

    public abstract UserModel GuardarUser(UserModel usuario);
    public abstract ArrayList<UserModel> TodosUsers();
    public abstract String ValidarUseryPass (String user);
    public abstract ArrayList<UserModel> BuscarUser(String user);
    public abstract Optional<UserModel> BuscarXId(Long ID);
    public abstract ArrayList<UserModel> BuscarContrasena(String password);
    public String ValidarCredenciales(String password);

}
