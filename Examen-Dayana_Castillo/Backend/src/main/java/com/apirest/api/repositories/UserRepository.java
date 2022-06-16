package com.apirest.api.repositories;

//import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apirest.api.models.UserModel;

@Repository // agregamos la notacion q va hacer de tipo repositori
public interface UserRepository extends CrudRepository<UserModel, Long> { // va hacer una interfaz porq va a utilizar
                                                                          // ciertos me todos como crud ya esta

    // public abstract ArrayList<UserModel> findByPrioridad(Integer prioridad);
}
