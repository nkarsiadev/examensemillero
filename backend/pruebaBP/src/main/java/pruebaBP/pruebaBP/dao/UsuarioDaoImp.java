// package io.github.jiangdequan;
package pruebaBP.pruebaBP.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.boot.context.annotation.UserConfigurations;
import org.springframework.stereotype.Repository;

import pruebaBP.pruebaBP.models.Usuario;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {
    
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> getAllUsuarios(){
        String query = "FROM Usuario";

        List<Usuario> usuarios = entityManager.createQuery(query).getResultList();

        return usuarios;
    }

    @Override
    public String loginUsuario(Usuario user){
        // System.out.println(user.getUsuario()+" "+ user.getContrasena());

        Usuario usuario = entityManager.find(Usuario.class, user.getUsuario());

        if(usuario == null){
            return "Usuario no encontrado";
        }else {
            if(user.getContrasena().equals(usuario.getContrasena())){
                return user.getUsuario();
            }else{
                return "Contrasena es incorrecta";
    
            } 
        }
        // System.out.println(user.getUsuario()== usuario.getUsuario());
        // System.out.println(user.getContrasena().equals(usuario.getContrasena().toString()));
        // System.out.println(usuario.equals(user));

        // System.out.println(usuario);
        

    }
    @Override
    public Usuario registrarUsuario(Usuario user){
        Usuario newUser = entityManager.merge(user);
        return newUser;
    }

    @Override
    public String eliminarAllUsuarios() {
        // TODO Auto-generated method stub        
        entityManager.clear();
        return "Usuarios eliminados";
        
    }

}