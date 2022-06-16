package com.banco.pichincha.pruebaback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.pichincha.pruebaback.enities.Session;
import com.banco.pichincha.pruebaback.enities.Usuarios;

@Service
public class SessionService implements SessionServiceI {

    @Autowired
    UsuariosServiceI usuariosService;

    public Session getSession(String name, String password, String mail) {
        Usuarios usuarioEncontrado = new Usuarios();
        if (mail == "") {
            usuarioEncontrado = usuariosService.verifyUserByNameAndPassword(name, password);
        } else {
            usuarioEncontrado = usuariosService.verifyUserByMailndPassword(mail, password);
        }
        if (usuarioEncontrado != null) {
            Session session = new Session();
            session.setNombreUsuario(usuarioEncontrado.getNameUsuario());
            session.setEmailUsuario(usuarioEncontrado.getEmailUsuario());
            session.setIdRol(usuarioEncontrado.getRol().getIdRol().toString());
            session.setPasswordUsuario(usuarioEncontrado.getPasswordUsuario());
            session.setNombreRol(usuarioEncontrado.getRol().getNameRol());
            session.setTokenSession("token");

            return session;
        } else {
            return null;
        }
    }
}
