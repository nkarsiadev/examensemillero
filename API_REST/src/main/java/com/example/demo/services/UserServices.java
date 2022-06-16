package com.example.demo.services;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.functions.CompararCredenciales;
import com.example.demo.functions.*;
import com.example.demo.models.UserModel;
import com.example.demo.repositories.*;

@Service
public class UserServices implements IUserServices {
    @Autowired
    UserRepository UserRepository;

    @Override
    public UserModel GuardarUser(UserModel usuario) {
        UserModel aux = UserRepository.save(usuario);
        return aux;
    }

    @Override
    public ArrayList<UserModel> TodosUsers() {
        
        ArrayList<UserModel> Lista = (ArrayList<UserModel>) UserRepository.findAll();
        return Lista;
    }

    @Override
    public boolean ValidarUseryPass(String user) {
        // TODO Auto-generated method stub
        ArrayList<UserModel> Lista, aux;
        Lista = TodosUsers();
        aux = BuscarUsuario(user);
        if (aux.size()<0){
            return true;
        }else{
            boolean aux2 = new CompararUser().Comparar(aux.get(0), Lista);
            return aux2;
        }
    }

    @Override
    public boolean ValidarPass (String user){
        ArrayList<UserModel> usuario, Lista;
        Lista = TodosUsers();
        usuario = BuscarUsuario(user);
        boolean aux = new CompararCredenciales().Comparar(usuario.get(0), Lista);
        return aux;
    }

    @Override
    public ArrayList<UserModel> BuscarUsuario(String user) {
        // TODO Auto-generated method stub
        return this.UserRepository.findByuser(user);
    }

    @Override
    public ArrayList<UserModel> BuscarContrasena(String password) {
        // TODO Auto-generated method stub
        return this.UserRepository.findByPassword(password);
    }
    

    @Override
    public Optional<UserModel> BuscarXId(Long id){
        Optional<UserModel> Finduser;
        Finduser = UserRepository.findById(id); 
        return Finduser;    
    }

}
