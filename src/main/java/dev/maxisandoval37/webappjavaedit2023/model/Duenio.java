package dev.maxisandoval37.webappjavaedit2023.model;

import jakarta.persistence.*;

@Entity
public class Duenio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;

    private String direccion;

    public Duenio() {}

    public Duenio(Long id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

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

    public String getDireccion () {
        return direccion;
    }

    public void setDireccion (String direccion) {
        this.direccion = direccion;
    }
}