package com.game.repositories;

import com.game.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByNombre(String nombreUsuario);
    Optional<Usuario> findByCorreoAndClave(String correoUsuario, String claveUsuario);
}