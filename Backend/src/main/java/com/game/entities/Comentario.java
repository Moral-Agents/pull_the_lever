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

    @ManyToOne
    @JoinColumn(
            name = "pregunta_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name="pregunta_respuesta_fk"
            )
    )
    private Pregunta pregunta;

    @ManyToOne
    @JoinColumn(
            name = "usuario_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name="usuario_respuesta_fk"
            )
    )
    private Usuario usuario;

}
