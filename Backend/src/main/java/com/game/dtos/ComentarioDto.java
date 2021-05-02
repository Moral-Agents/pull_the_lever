package com.game.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComentarioDto {
    private Long id;
    private String comentario;
    private Long preguntaId;
    private Long usuarioId;
}