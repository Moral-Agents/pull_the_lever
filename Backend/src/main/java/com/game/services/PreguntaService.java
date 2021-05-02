package com.game.services;

import com.game.dtos.PreguntaDto;
import com.game.exceptions.GameException;

import java.util.List;

public interface PreguntaService {
    List<PreguntaDto> getPreguntas() throws GameException;
}
