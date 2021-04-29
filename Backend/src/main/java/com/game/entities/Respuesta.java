package com.game.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
        name="respuesta"
)

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Respuesta {
    @Id
    @SequenceGenerator(
            name = "respuesta_sequence",
            sequenceName = "respuesta_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "respuesta_sequence"
    )

    @Column(
            name = "respuesta",
            nullable = false,
            columnDefinition = "SMALLINT"
    )
    private Boolean respuesta;

    @Column(
            name="edad",
            nullable = false,
            columnDefinition = "INTEGER"
    )
    private Integer edad;

    @Column(
            name="nacionalidad",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nacionalidad;

    @Column(
            name="genero",
            nullable = false,
            columnDefinition = "CHAR"
    )
    private Character genero;
}