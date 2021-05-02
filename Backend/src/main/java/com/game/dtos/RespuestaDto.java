package com.game.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaDto {
    private Boolean respuesta;
    private Integer edad;
    private String nacionalidad;
    private Character genero;
    private Long preguntaId;
    private Long usuarioId;
}
