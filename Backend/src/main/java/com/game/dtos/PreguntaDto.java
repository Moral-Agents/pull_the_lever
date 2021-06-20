package com.game.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PreguntaDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private String opcion_1;
    private String opcion_2;
    private String img;
    private Long cant_1;
    private Long cant_2;
    private Long visitas;
    private LocalDateTime fecha_creacion;
    private String autor;
}