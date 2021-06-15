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
    private String img;
    private Long cant_si;
    private Long cant_no;
    private Long visitas;
    private LocalDateTime fecha_creacion;
}