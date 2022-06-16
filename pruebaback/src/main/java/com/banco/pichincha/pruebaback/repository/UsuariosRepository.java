package com.banco.pichincha.pruebaback.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.pichincha.pruebaback.enities.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    // generacion de peticiones a la BD
    Optional<Usuarios> findByNameUsuario(String nameUsuario);

    Optional<Usuarios> findByEmailUsuario(String emailUsuario);

    boolean existsByNameUsuarioAndPasswordUsuario(String nameUsuario, String passwordUsuario);

    boolean existsByEmailUsuarioAndPasswordUsuario(String emailUsuario, String passwordUsuario);
}
