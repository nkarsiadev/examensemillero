package com.banco.pichincha.pruebaback.service;

import java.util.List;

import com.banco.pichincha.pruebaback.enities.Roles;

public interface RolesServiceI {

    public List<Roles> getAllRoles();

    public Roles findById(Long id);
}
