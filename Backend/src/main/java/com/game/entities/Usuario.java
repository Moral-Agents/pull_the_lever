package com.game.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name="usuario",
        uniqueConstraints = {
                @UniqueConstraint(name ="usuario_nombre_unique",
                        columnNames = "nombre"),
                @UniqueConstraint(name ="usuario_correo_unique",
                        columnNames = "correo")
        }
)

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(
                name="id",
                updatable = false
        )
        private Long id;

        @Column(
                name="correo",
                nullable = false,
                columnDefinition = "TEXT"
        )
        private String correo;

        @Column(
                name="clave",
                nullable = false,
                columnDefinition = "TEXT",
                length = 30
        )
        private String clave;

        @Column(
                name="nombre",
                nullable = false,
                columnDefinition = "TEXT",
                length = 30
        )
        private String nombre;

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

        @Column(
                name="tipo",
                nullable = false,
                columnDefinition = "CHAR"
        )
        private Character tipo;

        @OneToMany(
                mappedBy = "usuario",
                cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
                fetch = FetchType.LAZY
        )
        private List<Respuesta> respuestas =new ArrayList<>();

        @OneToMany(
                mappedBy = "usuario",
                cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
                fetch = FetchType.LAZY
        )
        private List<Comentario> comentarios =new ArrayList<>();
}
