package com.casadocodigo.dto;

import com.casadocodigo.domain.Autor;

import javax.validation.constraints.*;

public class NovoAutorRequest {

    @NotBlank
    public String nome;
    @NotBlank
    @Email
    public String email;
    @NotBlank
    @Size(max = 400)
    public String descricao;

    public Autor toModel() {
        return new Autor(nome, email, descricao);
    }

}
