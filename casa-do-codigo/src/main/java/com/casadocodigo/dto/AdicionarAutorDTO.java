package com.casadocodigo.dto;

import com.casadocodigo.domain.Autor;

import javax.validation.constraints.*;

public class AdicionarAutorDTO {

    @NotBlank
    public String nome;
    @NotBlank
    @Email
    public String email;
    @NotBlank
    @Size(max = 400)
    public String descricao;

    public AdicionarAutorDTO() {
    }

    public AdicionarAutorDTO(@NotBlank String nome,
                             @NotBlank @Email String email,
                             @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converter() {
        return new Autor(nome, email, descricao);
    }

}
