package com.game.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUsuarioDto {
    private String nombre;
    private Integer edad;
    private String nacionalidad;
    private Character genero;
    private Character tipo;
}