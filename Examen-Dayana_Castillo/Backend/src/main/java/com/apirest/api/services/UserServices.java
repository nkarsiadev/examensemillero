package com.apirest.api.services;

import java.util.ArrayList;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.apirest.api.models.UserModel;
import com.apirest.api.repositories.*;

//import ch.qos.logback.classic.joran.action.ConsolePluginAction;

@Service // clase de tipo servicio
public class UserServices {
    @Autowired // notacion q no se instancia
    UserRepository UserRepository;// asi llamamos la instancia del repositorio

    public ArrayList<UserModel> obtUsers() {
        return (ArrayList<UserModel>) UserRepository.findAll();
    }

    public UserModel SaveUser(UserModel usuario) {
        return UserRepository.save(usuario);
    }

    /*
     * public Optional<UserModel> obtenerPorId(Long id) {
     * return UserRepository.findById(id);
     * }
     * 
     * 
     * public ArrayList<UserModel> obtenerPorPrioridad(Integer prioridad) {
     * return UserRepository.findByPrioridad(prioridad);
     * }
     * 
     * public boolean eliminarUsuario(Long id) {
     * try {
     * UserRepository.deleteById(id);
     * System.out.println("Usuario Eliminado exitosamente");
     * return true;
     * } catch (Exception err) {
     * 
     * System.out.println("Algo falló al eliminar Usurio");
     * return false;
     * }
     * }
     */

}
