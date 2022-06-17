package com.example.demo.services;
import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UserModel;

public abstract interface IUserServices {
    public UserModel GuardarUser(UserModel usuario);
    public ArrayList<UserModel> TodosUsers();
    public boolean ValidarUseryPass (String user);
    public Optional<UserModel> BuscarXId(Long id);
    public ArrayList<UserModel> BuscarUsuario(String user);
    public boolean ValidarPass (String user);
    public ArrayList<UserModel> BuscarContrasena(String password);
}
