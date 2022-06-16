package pichincha.com.maaseichaq.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pichincha.com.maaseichaq.Entidad.Usuario;
import pichincha.com.maaseichaq.Excepciones.Excepcion.BadRequestException;
import pichincha.com.maaseichaq.Excepciones.Excepcion.NotFoundException;
import pichincha.com.maaseichaq.IServicio.UsuarioIServicio;
import pichincha.com.maaseichaq.Repositorio.UsuarioRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio implements UsuarioIServicio {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = (List<Usuario>) usuarioRepositorio.findAll();
        if (usuarios.size() > 0){
            for (int i=0;i<usuarios.size();i++){
                String btnEdit = "<button class='btn btn-warning btn-sm' onclick='fntEditInfo("+usuarios.get(i).getId_usuario()+")' title='Editar Usuario'><i class='fas fa-pencil-alt'></i></button>";
                String btnDel = "<button class='btn btn-danger btn-sm' onclick='fntDelInfo("+usuarios.get(i).getId_usuario()+")' title='Eliminar Usuario'><i class='far fa-trash-alt'></i></button>";
                usuarios.get(i).setOptions("<div class='text-center'>"+btnEdit+" "+btnDel+"</div>");
            }
            return usuarios;
        }
        throw new NotFoundException("{\"message\":\"No existen usuarios registrados\",\"status\":false,\"data\":[]}");
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        try {
            String email = usuario.getEmail_usuario();
            if (!usuarioRepositorio.existByEmail(email)){
                return usuarioRepositorio.save(usuario);
            }else{
                throw new BadRequestException("Ya existe un usuario registrado con el email "+email);
            }
        }catch (Exception e){
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public Usuario entrarSistema(String email, String contrasenia) {
        if (usuarioRepositorio.existByEmail(email)){
            Usuario usuario = usuarioRepositorio.traerByEmail(email);
            if (usuario.getContrasenia_usuario().equals(contrasenia)){
                return usuario;
            }else {
                throw new BadRequestException("La contraseña ("+contrasenia+") con coincide");
            }
        }else {
            throw new NotFoundException("No existe el usuario con el email "+email);
        }
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        if (usuarioRepositorio.existsById(id))
            return usuarioRepositorio.findById(id);
        throw new NotFoundException("No existe el usuario con el id "+id);
    }

    @Override
    public Usuario obtenerUsuarioPorEmail(String email) {
        if (usuarioRepositorio.existByEmail(email))
            return usuarioRepositorio.traerByEmail(email);
        throw new NotFoundException("No existe el usuario con el email "+email);
    }

    @Override
    public String eliminarUsuario(Long id) {
        if (usuarioRepositorio.existsById(id)){
            usuarioRepositorio.deleteById(id);
            return "{\"message\":\"Usuario eliminado exitosamente\",\"status\":true}";
        }
        throw new NotFoundException("{\"message\":\"No existe el usuario con el id "+id+"\",\"status\":false}");
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        if (usuarioRepositorio.existsById(id)){
            if (usuario != null){
                String emailUsuario = usuario.getEmail_usuario();
                Usuario user = usuarioRepositorio.traerByEmail(emailUsuario);
                    if (emailUsuario.equals(user.getEmail_usuario())){
                        usuario.setId_usuario(id);
                        return usuarioRepositorio.save(usuario);
                    }else {
                        throw new BadRequestException("No se puede modificar la cedula");
                    }
            }else {
                throw new BadRequestException("Error de datos");
            }
        }else {
            throw new NotFoundException("No existe el usuario con el id "+id);
        }
    }
}
