package pichincha.com.maaseichaq.IServicio;

import pichincha.com.maaseichaq.Entidad.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioIServicio {
    public List<Usuario> obtenerUsuarios();
    public Usuario guardarUsuario(Usuario usuario);
    public Usuario entrarSistema(String email, String contrasenia);
    public Optional<Usuario> obtenerUsuarioPorId(Long id);
    public Usuario obtenerUsuarioPorEmail(String email);
    public String eliminarUsuario(Long id);
    public Usuario actualizarUsuario(Long id, Usuario usuario);
}
