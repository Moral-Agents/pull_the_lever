package com.game.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
        name="comentario"
)

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comentario {
    @Id
    @SequenceGenerator(
            name = "comentario_sequence",
            sequenceName = "comentario_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comentario_sequence"
    )

    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "comentario",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String comentario;

}
