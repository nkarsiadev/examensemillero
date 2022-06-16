package pichincha.com.maaseichaq.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pichincha.com.maaseichaq.Entidad.Usuario;
import pichincha.com.maaseichaq.Servicio.UsuarioServicio;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario/")
public class UsuarioControlador {
    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("listar")
    public ResponseEntity<List<Usuario>> obtenerUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.obtenerUsuarios());
    }

    @GetMapping(path = "{email}/{contrasenia}")
    public ResponseEntity<Usuario> entrarSistema(@PathVariable("email") String email, @PathVariable("contrasenia") String contrasenia){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.entrarSistema(email,contrasenia));
    }

    @PostMapping("save")
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServicio.guardarUsuario(usuario));
    }
	@GetMapping(path = "/buscar/{id}")
    public ResponseEntity<Optional<Usuario>> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.obtenerUsuarioPorId(id));
    }
    @GetMapping(path = "/email/{email}")
    public ResponseEntity<Usuario> obtenerPorEmail(@PathVariable("email") String email){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.obtenerUsuarioPorEmail(email));
    }
    
    @DeleteMapping(path = "/del/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServicio.eliminarUsuario(id));
    }
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Usuario> modificarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServicio.actualizarUsuario(id,usuario));
    }
}
