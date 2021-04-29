package com.game.entities;

import javax.persistence.Entity;

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
    private short respuesta;


}