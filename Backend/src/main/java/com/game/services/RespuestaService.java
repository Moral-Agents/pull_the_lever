package com.game.services;

import com.game.dtos.CreateRespuestaDto;
import com.game.dtos.RespuestaDto;
import com.game.exceptions.GameException;

import java.util.List;

public interface RespuestaService {
    RespuestaDto createRespuesta(CreateRespuestaDto createRespuestaDto) throws GameException;
    List<RespuestaDto> getRespuestasByPreguntaId(Long preguntaId) throws GameException;
    RespuestaDto getRespuestaByPreguntaIdAndUsuarioId(Long preguntaId, Long usuarioId) throws GameException;
}
