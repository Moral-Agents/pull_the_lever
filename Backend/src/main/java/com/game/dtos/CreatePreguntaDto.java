package com.game.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePreguntaDto {
    private String nombre;
    private String img;
    private Long cant_si;
    private Long cant_no;
}
