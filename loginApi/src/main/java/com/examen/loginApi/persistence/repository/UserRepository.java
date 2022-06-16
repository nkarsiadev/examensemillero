package com.examen.loginApi.persistence.repository;

import com.examen.loginApi.persistence.crud.UserCRUDRepository;
import com.examen.loginApi.persistence.entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository{
    @Autowired
    private UserCRUDRepository userCRUD;

    public List<User> getAllUsers(){
        return userCRUD.findAll();
    }

    public User findByEmail(String email) throws Exception {
        Optional<User> user = userCRUD.findByEmail(email);
        if(user.isPresent()) {
            return user.get();
        }
        throw new Exception("Error");
    }

    public User getLogin(String email, String password) throws Exception {
        User user = findByEmail(email);
        if (user.getPassword().equals(password)){
            return user;
        }else {
            throw new Exception("Error");
        }
    }

}
