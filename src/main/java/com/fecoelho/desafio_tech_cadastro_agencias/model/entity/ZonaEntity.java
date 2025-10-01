package com.fecoelho.desafio_tech_cadastro_agencias.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "zona")
public class ZonaEntity {
    @Id
    @Column(name = "id_zona", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer idZona;

    @Column(name = "nome_zona", nullable = false)
    String nomeZona;

    public ZonaEntity() {
    }

    public ZonaEntity(String nomeZona) {
        this.nomeZona = nomeZona;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public String getNomeZona() {
        return nomeZona;
    }
}
