package com.casadocodigo.domain;

import com.casadocodigo.dto.AdicionarAutorDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "autor")
public class Autor extends PanacheEntity {

    public String nome;
    public String email;
    public String descricao;
    @CreationTimestamp
    public Instant dataCriacao;
    @UpdateTimestamp
    public Instant dataAtualizacao;

    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
}
