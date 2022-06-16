package com.examen.loginApi.service;

import com.examen.loginApi.persistence.crud.UserCRUDRepository;
import com.examen.loginApi.persistence.entitys.User;
import com.examen.loginApi.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserCRUDRepository userCRUDRepository;

    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users;
        try {
            users = userRepository.getAllUsers();
            return ResponseEntity.ok(users);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    public ResponseEntity<User> findByEmail(String email){
        User user;
        try {
            user = userRepository.findByEmail(email);
            return ResponseEntity.ok(user);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    public ResponseEntity<User> getUserLogin(String email, String password){
        try{
            return ResponseEntity.ok(userRepository.getLogin(email, password));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
