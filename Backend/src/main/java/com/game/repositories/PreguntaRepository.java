package com.game.repositories;

import com.game.entities.Pregunta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
    Optional<Pregunta> findById(Long id);

    @Query("SELECT Preg FROM Pregunta Preg")
    List<Pregunta> findPreguntas();

    Page<Pregunta> findAll(Pageable pageable);
}
