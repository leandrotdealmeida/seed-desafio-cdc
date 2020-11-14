package com.casadocodigo.dto;

import com.casadocodigo.domain.Autor;

public class AutorResponse {

    public Long id;
    public String nome;
    public String email;
    public String descricao;

    public AutorResponse(Autor autor) {
        id = autor.id;
        nome = autor.nome;
        email = autor.email;
        descricao = autor.descricao;
    }
}
