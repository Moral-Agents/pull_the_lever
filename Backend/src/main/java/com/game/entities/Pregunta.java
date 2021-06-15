package com.game.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
            name = "img",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String img;

    @Column(
            name = "cant_si",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Long cant_si;

    @Column(
            name = "cant_no",
            nullable = false,
            columnDefinition = "BIGINT"
    )
    private Long cant_no;

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
