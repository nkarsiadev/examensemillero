// package io.github.jiangdequan;
package pruebaBP.pruebaBP.dao;

import java.util.List;
import pruebaBP.pruebaBP.models.Usuario;

public interface UsuarioDao {
    public Usuario registrarUsuario(Usuario usuario);
    public List<Usuario> getAllUsuarios();
    public String loginUsuario(Usuario user);
    public String eliminarAllUsuarios();
}