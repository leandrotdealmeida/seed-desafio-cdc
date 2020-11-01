package com.casadocodigo.dto;

import javax.validation.constraints.*;

public class AdicionarAutorDTO {

    @NotBlank(message = "Campo nome não pode estar vazio ou nulo")
    public String nome;
    @NotBlank(message = "Campo email não pode estar vazio ou nulo")
    @Email(message = "Email inválido")
    public String email;
    @NotBlank(message = "Campo descricao não pode estar vazio ou nulo")
    @Size(message = "Campo descrição ultrassou o limite máximo de 400 caracteres", max = 400)
    public String descricao;

}
