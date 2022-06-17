package com.pichincha.backTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.backTest.entity.Usuario;

@Repository
public interface UsuarioService extends JpaRepository<Usuario, Long> {

}
