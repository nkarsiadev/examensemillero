package com.examen.loginApi.persistence.crud;

import com.examen.loginApi.persistence.entitys.User;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserCRUDRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
