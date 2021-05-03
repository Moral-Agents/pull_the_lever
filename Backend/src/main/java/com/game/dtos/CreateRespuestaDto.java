package com.game.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRespuestaDto {
    private Short respuesta;
    private Integer edad;
    private String nacionalidad;
    private Character genero;
    private Long preguntaId;
    private Long usuarioId;
}
