package com.game.services;

import com.game.dtos.CreatePreguntaDto;
import com.game.dtos.PreguntaDto;
import com.game.exceptions.GameException;

import java.util.List;

public interface PreguntaService {
    PreguntaDto createPregunta(CreatePreguntaDto createPreguntaDto) throws GameException;
    PreguntaDto getPreguntaById(Long preguntaId) throws GameException;
    List<PreguntaDto> getPreguntas() throws GameException;
}
