package com.casadocodigo.dto;

import com.casadocodigo.domain.Categoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    public String nome;

    public Categoria toModel() {
        return new Categoria(nome);
    }
}
