package com.banco.pichincha.pruebaback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.pichincha.pruebaback.enities.Usuarios;
import com.banco.pichincha.pruebaback.repository.UsuariosRepository;

@Service
public class UsuariosService implements UsuariosServiceI {

    @Autowired
    UsuariosRepository usuariosRepository;

    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    public Usuarios getUsuarioName(String valueUserName) {
        Optional<Usuarios> usuarioEncontrado = usuariosRepository.findByNameUsuario(valueUserName);
        return usuarioEncontrado.get();
    }

    public Usuarios getUsuarioEmail(String valueEmail) {
        Optional<Usuarios> usuarioEncontrado = usuariosRepository.findByEmailUsuario(valueEmail);
        return usuarioEncontrado.get();
    }

    public Usuarios verifyUserByNameAndPassword(String name, String password) {
        boolean resultFind = usuariosRepository.existsByNameUsuarioAndPasswordUsuario(name, password);

        if (resultFind) {
            return usuariosRepository.findByNameUsuario(name).get();
        } else {
            return null;
        }
    }

    public Usuarios verifyUserByMailndPassword(String mail, String password) {
        boolean resultFind = usuariosRepository.existsByEmailUsuarioAndPasswordUsuario(mail, password);

        if (resultFind) {
            return usuariosRepository.findByEmailUsuario(mail).get();
        } else {
            return null;
        }
    }

}
