package com.HealthLab.HealthLab.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fac_p_cups")
public class FacPCups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo", nullable = false, length = 8)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 500)
    private String nombre;

    @Column(name = "habilita", columnDefinition = "boolean default true")
    private Boolean habilita = true;

    // Constructor por defecto
    public FacPCups() {}

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getHabilita() {
        return habilita;
    }

    public void setHabilita(Boolean habilita) {
        this.habilita = habilita;
    }
}
