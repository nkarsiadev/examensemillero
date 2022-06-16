package com.banco.pichincha.pruebaback.service;

import java.util.List;

import com.banco.pichincha.pruebaback.enities.Usuarios;

public interface UsuariosServiceI {

    public List<Usuarios> getAllUsuarios();

    public Usuarios getUsuarioName(String valueUserName);

    public Usuarios getUsuarioEmail(String valueEmail);

    public Usuarios verifyUserByNameAndPassword(String name, String password);

    public Usuarios verifyUserByMailndPassword(String mail, String password);
}
