package com.prueba.apibackend.repositories;

import com.prueba.apibackend.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {
    public default ArrayList<UserModel> findByEmail(String user_email) {
        return null;
    }
}
