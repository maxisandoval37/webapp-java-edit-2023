package dev.maxisandoval37.webappjavaedit2023.model;

import jakarta.persistence.*;

@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;
    private String especie;
    private int edad;

    @ManyToOne
    private Duenio duenio;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie () {
        return especie;
    }

    public void setEspecie (String especie) {
        this.especie = especie;
    }

    public int getEdad () {
        return edad;
    }

    public void setEdad (int edad) {
        this.edad = edad;
    }

    public Duenio getDuenio () {
        return duenio;
    }

    public void setDuenio (Duenio duenio) {
        this.duenio = duenio;
    }
}