package pruebaBP.pruebaBP.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pruebaBP.pruebaBP.dao.UsuarioDao;
import pruebaBP.pruebaBP.models.Usuario;

@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioDao usuarioDao;

    @CrossOrigin
    @RequestMapping(value ="usuarios", method=RequestMethod.GET)
    public List<Usuario> getAllUsuarios(){
        Usuario user1 = new Usuario("daniel", "1234");
        Usuario user2 = new Usuario("daniel", "1234");
        Usuario user3 = new Usuario("daniel", "1234");

        List<Usuario> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        // return users;
        return usuarioDao.getAllUsuarios();
    }   
    
    
    @CrossOrigin
    @RequestMapping(value ="usuarios/login", method=RequestMethod.POST)
    public String loginUsuario(@RequestBody Usuario usuario){
        Usuario user = new Usuario();
        user.setUsuario("danielcr"); 
        user.setContrasena("1234");
        // return user;
        return usuarioDao.loginUsuario(usuario);
    } 
    
     // crea un usuario
     
    @CrossOrigin
    @RequestMapping(value = "usuarios/registrar", method = RequestMethod.POST)
     public Usuario crearUsuario(@RequestBody Usuario usuario) {
         return usuarioDao.registrarUsuario(usuario);
     }

    @CrossOrigin
    @RequestMapping(value = "usuarios/eliminar", method = RequestMethod.DELETE)
    public String eliminarAllUsuarios() {
        // Usuario<Long, String> usuario = new Usuario<>();                       
        return usuarioDao.eliminarAllUsuarios(); 
       
    }


}
