package com.game.repositories;

import com.game.entities.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    Optional<Comentario> findById(Long id);
    Optional<Comentario> findByPreguntaIdAndUsuarioId(Long preguntaId,Long usuarioId);

    @Query("SELECT c FROM Comentario c WHERE c.pregunta.id =?1")
    List<Comentario> findAllByPreguntaId(Long preguntaId);
}
