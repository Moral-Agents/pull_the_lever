package com.game.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name="comentario"
)

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(
            name = "fecha_creacion",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime fecha_creacion;

    @Column(
            name = "autor",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String autor;

    @Column(
            name = "img",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String img;

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
