package com.game.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name="pregunta",
        uniqueConstraints = {
                @UniqueConstraint(name ="pregunta_nombre_unique",
                        columnNames = "nombre")
        }
)

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "nombre",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nombre;

    @Column(
            name = "descripcion",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String descripcion;

    @Column(
            name = "img",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String img;

    @Column(
            name = "opcion_1",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String opcion_1;

    @Column(
            name = "opcion_2",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String opcion_2;

    @Column(
            name = "cant_1",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Long cant_1;

    @Column(
            name = "cant_2",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Long cant_2;

    @Column(
            name = "visitas",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Long visitas;

    @Column(
            name = "fecha_creacion",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime fecha_creacion;


    @OneToMany(
            mappedBy = "pregunta",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Respuesta> respuestas =new ArrayList<>();

    @OneToMany(
            mappedBy = "pregunta",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Comentario> comentarios =new ArrayList<>();

}
