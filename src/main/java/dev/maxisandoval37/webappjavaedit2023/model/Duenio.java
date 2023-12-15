package dev.maxisandoval37.webappjavaedit2023.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //toString, equals, hashcode, getters y setter
@NoArgsConstructor
@AllArgsConstructor
public class Duenio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;

    private String direccion;
}