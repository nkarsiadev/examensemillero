package pichincha.com.maaseichaq.Repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pichincha.com.maaseichaq.Entidad.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
    @Query(value = "SELECT * FROM usuario u WHERE u.email_usuario LIKE %:email_usuario%",nativeQuery = true)
    public Usuario traerByEmail(@Param("email_usuario") String email_usuario);
    @Query(value = "SELECT COUNT(u.id_usuario) = 1 FROM usuario u WHERE u.email_usuario LIKE %:email%",nativeQuery = true)
    public Boolean existByEmail(@Param("email") String email);
}
