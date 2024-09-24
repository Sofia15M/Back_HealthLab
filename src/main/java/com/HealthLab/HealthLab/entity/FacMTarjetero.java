package com.HealthLab.HealthLab.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fac_m_tajetero")
public class FacMTarjetero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String historia;

    @ManyToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_regimen", referencedColumnName = "id")
    private Regimen regimen;

    @ManyToOne
    @JoinColumn(name = "id_eps", referencedColumnName = "id")
    private Eps eps;

    @ManyToOne
    @JoinColumn(name = "id_nivel", referencedColumnName = "id")
    private Nivel nivel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Historia getHistoria() {
        return historia;
    }

    public void setHistoria(Historia historia) {
        this.historia = historia;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Regimen getRegimen() {
        return regimen;
    }

    public void setRegimen(Regimen regimen) {
        this.regimen = regimen;
    }

    public Eps getEps() {
        return eps;
    }

    public void setEps(Eps eps) {
        this.eps = eps;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
