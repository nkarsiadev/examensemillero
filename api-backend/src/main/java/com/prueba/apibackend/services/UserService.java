package com.prueba.apibackend.services;

import com.prueba.apibackend.models.UserModel;
import com.prueba.apibackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    //Listar Usuarios
    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    //Encontrar usuario por email
    public ArrayList<UserModel> obtenerPorEmail(String user_email){
        return userRepository.findByEmail(user_email);
    }
}
