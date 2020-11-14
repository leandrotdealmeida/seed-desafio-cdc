package com.casadocodigo.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.smallrye.common.constraint.Assert;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
public class Autor extends PanacheEntity {

    @NotBlank
    public String nome;
    @NotBlank
    @Email
    public String email;
    @NotBlank
    @Size(max = 400)
    public String descricao;
    @CreationTimestamp
    public Instant dataCriacao;
    @UpdateTimestamp
    public Instant dataAtualizacao;

    public Autor() { }

    public Autor(@NotBlank String nome,
                 @NotBlank @Email String email,
                 @NotBlank @Size(max = 400) String descricao) {
        Assert.checkNotEmptyParam(nome, "O Nome é obrigatório");

        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

}


