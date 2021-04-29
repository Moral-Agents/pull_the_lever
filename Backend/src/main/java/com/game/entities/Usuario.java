package com.game.entities;

import javax.persistence.Entity;

@Entity
@Table(
        name="Usuario",
        uniqueConstraints = {
                @UniqueConstraint(name ="usuario_nombre_unique",
                        columnNames = "nombre")
        }
)

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
        @Id
        @SequenceGenerator(
                name="usuario_sequence",
                sequenceName = "usuario_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "usuario_sequence"
        )

        @Column(
                name="id",
                updatable = false
        )
        private Long id;

        @Column(
                name="nombre",
                nullable = false,
                columnDefinition = "TEXT"
        )
        private String nombre;

        @Column(
                name="edad",
                nullable = false,
                columnDefinition = "INTEGER"
        )
        private int edad;

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
        private Char genero;

        @Column(
                name="tipo",
                nullable = false,
                columnDefinition = "CHAR"
        )
        private Char tipo;

}
