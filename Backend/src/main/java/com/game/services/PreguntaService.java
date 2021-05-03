package com.game.services;

import com.game.dtos.CreatePreguntaDto;
import com.game.dtos.PreguntaDto;
import com.game.exceptions.GameException;

public interface PreguntaService {
    PreguntaDto createPregunta(CreatePreguntaDto createPreguntaDto) throws GameException;
}
