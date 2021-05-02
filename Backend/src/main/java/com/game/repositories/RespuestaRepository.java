package com.game.repositories;

import com.game.entities.Comentario;
import com.game.entities.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    Optional<Respuesta> findById(Long id);
    Optional<Respuesta> findByPreguntaIdAndUsuarioId(Long preguntaId, Long usuarioId);

    @Query("SELECT r FROM Respuesta r WHERE r.pregunta.id =?1")
    List<Respuesta> findAllByPreguntaId(Long preguntaId);
}
