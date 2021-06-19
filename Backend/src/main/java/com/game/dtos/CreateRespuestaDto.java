package com.game.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRespuestaDto {
    private Short respuesta;
    private Long preguntaId;
    private Long usuarioId;
}
