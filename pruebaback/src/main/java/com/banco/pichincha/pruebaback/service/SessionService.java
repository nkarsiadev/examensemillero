package com.banco.pichincha.pruebaback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.pichincha.pruebaback.enities.Session;
import com.banco.pichincha.pruebaback.enities.Usuarios;
import com.banco.pichincha.pruebaback.exception.UsuariosServiceException;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

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
            session.setIdRol(generateHashValueString(usuarioEncontrado.getRol().getIdRol().toString()));
            session.setPasswordUsuario(generateHashValueString(usuarioEncontrado.getPasswordUsuario()));
            session.setNombreRol(usuarioEncontrado.getRol().getNameRol());
            session.setTokenSession(("token"));

            return session;
        } else {
            return null;
        }
    }

    public String generateHashValueString(String value) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id, 32, 64);
        String hashValueEncripted = argon2.hash(10, 64, 1, value.toCharArray());

        return hashValueEncripted;
    }
}
