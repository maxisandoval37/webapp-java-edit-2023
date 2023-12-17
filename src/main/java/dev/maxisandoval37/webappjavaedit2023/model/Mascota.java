package dev.maxisandoval37.webappjavaedit2023.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data //toString, equals, hashcode, getters y setter
@NoArgsConstructor
@AllArgsConstructor
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NotBlank(message = "La especie no puede estar en blanco")
    private String especie;

    @Min(value = 0, message = "La edad debe ser menor que o igual a 20")
    @Max(value = 20, message = "La edad debe ser menor que o igual a 20")
    private int edad;

    @ManyToOne
    @NotNull(message = "El dueño no puede estar en blanco")
    private Duenio duenio;
}