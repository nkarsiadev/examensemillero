package com.by.demo.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.by.demo.models.User;



@Repository
public interface IUser extends JpaRepository<User, Long> {

	
	Optional<User> findByNameUser(String nameUser);

	Optional<User> findByEmailUser(String emailUser);

   //boolean existsByEmailUsuarioAndPasswordUsuario(String emailUser, String passwordUser);
	
	
	//public Boolean existByEmail(String emailUser);
	
}
