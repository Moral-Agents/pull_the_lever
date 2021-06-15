package com.game.services;

import com.game.dtos.ComentarioDto;
import com.game.dtos.CreateComentarioDto;
import com.game.exceptions.GameException;

import java.util.List;

public interface ComentarioService {
    ComentarioDto createComentario(CreateComentarioDto createComentarioDto) throws GameException;
    List<ComentarioDto> getComentariosByPreguntaId(Long preguntaId) throws GameException;
    void updateComentario(ComentarioDto comentarioDto) throws GameException;
    void deleteComentario(Long comentarioId);
}
