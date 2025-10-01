package com.fecoelho.desafio_tech_cadastro_agencias.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "agencia")
public class AgenciaEntity {
    @Id
    @Column(name = "id_agencia", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idAgencia;

    @Column(name = "nome_agencia", nullable = false)
    String nomeAgencia;

    @Column(name = "lng")
    Double lng; // x

    @Column(name = "lat")
    Double lat; // y

    @OneToOne
    @JoinColumn(name = "id_zona", nullable = false, insertable = false, updatable = false)
    ZonaEntity zonaEntity;

    @Column(name = "id_zona", nullable = false)
    Integer idZona;

    public AgenciaEntity() {
    }

    public AgenciaEntity(String nomeAgencia, Double lng, Double lat, Integer idZona) {
        this.nomeAgencia = nomeAgencia;
        this.lng = lng;
        this.lat = lat;
        this.idZona = idZona;
    }

    public Integer getIdAgencia() {
        return idAgencia;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public Double getLng() {
        return lng;
    }

    public Double getLat() {
        return lat;
    }

    public Integer getIdZona() {
        return idZona;
    }
}
