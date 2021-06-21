package com.game.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePreguntaDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private String opcion_1;
    private String opcion_2;
}
