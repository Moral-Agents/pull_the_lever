package com.game.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreatePreguntaDto {
    private String nombre;
    private String descripcion;
    private String img;
    private LocalDateTime fecha_creacion;
}
