package com.banco.pichincha.pruebaback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.pichincha.pruebaback.enities.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    // generacion de peticiones a la BD

}
