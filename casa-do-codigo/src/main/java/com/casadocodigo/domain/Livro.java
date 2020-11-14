package com.casadocodigo.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Livro extends PanacheEntity {

    @NotBlank
    public String titulo;
    @NotBlank
    @Size(max = 500)
    public String resumo;
    public String sumario;
    public Double preco;
    @NotNull
    public Integer paginas;
    @NotBlank
    public String isbn;
    public LocalDate dataPublicacao = LocalDate.now();
    @OneToOne(cascade = CascadeType.ALL)
    public Categoria categoria;
    @OneToOne(cascade = CascadeType.ALL)
    public Autor autor;
    @CreationTimestamp
    public Instant dataCriacao;
    @UpdateTimestamp
    public Instant dataAtualizacao;


    public Livro() {
    }

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario, @NotBlank @Size(min = 20) Double preco, @NotBlank @Size(min = 100) Integer paginas, @NotBlank String isbn) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
    }
}
