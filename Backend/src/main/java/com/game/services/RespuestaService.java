package com.game.services;

import com.game.dtos.CreateRespuestaDto;
import com.game.dtos.RespuestaDto;
import com.game.exceptions.GameException;

import java.util.List;

public interface RespuestaService {
    RespuestaDto createRespuesta(CreateRespuestaDto createRespuestaDto) throws GameException;
    List<RespuestaDto> getRespuestaByPreguntaId(Long preguntaId) throws GameException;
}
