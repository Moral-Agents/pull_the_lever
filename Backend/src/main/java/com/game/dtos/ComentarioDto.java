package com.game.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ComentarioDto {
    private Long id;
    private String comentario;
    private LocalDateTime fecha_creacion;
    private Long preguntaId;
    private Long usuarioId;
}