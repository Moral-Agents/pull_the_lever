package com.game.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateComentarioDto {
    private String comentario;
    private Long preguntaId;
    private Long usuarioId;
}
