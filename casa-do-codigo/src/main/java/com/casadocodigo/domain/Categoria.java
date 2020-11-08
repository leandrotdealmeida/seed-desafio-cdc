package com.casadocodigo.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria extends PanacheEntity {

    @NotBlank
    public String nome;

    public Categoria() {
    }

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }
}
