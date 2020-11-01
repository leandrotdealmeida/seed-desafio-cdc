package com.casadocodigo.domain;

import com.casadocodigo.dto.AdicionarAutorDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;

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

    public Autor() {
    }

    public Autor(AdicionarAutorDTO dto) {
        this.nome = dto.nome;
        this.email = dto.email;
        this.descricao = dto.descricao;
    }
}
