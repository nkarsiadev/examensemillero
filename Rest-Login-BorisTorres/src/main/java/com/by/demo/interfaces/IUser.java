package com.by.demo.interfaces;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.by.demo.models.User;



@Repository
public interface IUser extends CrudRepository<User, Long> {

	Optional<User> findByIdUser(Long idUser);
	
	Optional<User> findByEmailUser(String emailUser);
	
	//public Boolean existByEmail(String emailUser);
	
}
