package com.game.services;

import com.game.dtos.CreatePreguntaDto;
import com.game.dtos.PreguntaDto;
import com.game.entities.Pregunta;
import com.game.exceptions.GameException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PreguntaService {
    PreguntaDto createPregunta(CreatePreguntaDto createPreguntaDto) throws GameException;
    PreguntaDto getPreguntaById(Long preguntaId) throws GameException;
    List<PreguntaDto> getPreguntas() throws GameException;
    void updatePregunta(PreguntaDto preguntaDto) throws GameException;
    void deletePreguntaById(Long preguntaId);

    Page<Pregunta> findAll(Pageable pageable) throws GameException;
}
