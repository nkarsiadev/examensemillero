package com.banco.pichincha.pruebaback.service;

import java.util.List;

import com.banco.pichincha.pruebaback.enities.Usuarios;
import com.banco.pichincha.pruebaback.exception.UsuariosServiceException;

public interface UsuariosServiceI {

    public List<Usuarios> getAllUsuarios();

    public Usuarios getUsuarioName(String valueUserName) throws UsuariosServiceException;

    public Usuarios getUsuarioEmail(String valueEmail) throws UsuariosServiceException;

    public Usuarios verifyUserByNameAndPassword(String name, String password);

    public Usuarios verifyUserByMailndPassword(String mail, String password);
}
