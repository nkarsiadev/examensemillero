package com.banco.pichincha.pruebaback.exception;

public class UsuariosServiceNullException extends NullPointerException {

    public UsuariosServiceNullException(String message) {
        super(message);
    }

    public String usuarioVacio() {
        return "La instanciacion del usuario es nula";
    }
}
