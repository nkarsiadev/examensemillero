package com.banco.pichincha.pruebaback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.banco.pichincha.pruebaback.enities.Roles;
import com.banco.pichincha.pruebaback.repository.RolesRepository;

public class RolesService implements RolesServiceI {

    @Autowired
    RolesRepository rolesRepository;

    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    public Roles findById(Long id) {

        return rolesRepository.findById(id).get();
    }
}
