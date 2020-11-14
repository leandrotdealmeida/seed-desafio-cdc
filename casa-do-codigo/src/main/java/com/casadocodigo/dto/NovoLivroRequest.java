package com.casadocodigo.dto;

import com.casadocodigo.domain.Livro;
import org.checkerframework.common.aliasing.qual.Unique;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class NovoLivroRequest {

    @NotBlank
    public String titulo;
    @NotBlank
    @Size(max = 500)
    public String resumo;
    public String sumario;
    @NotBlank
    public String preco;
    @NotBlank
    public String paginas;
    @NotBlank
    public String isbn;

    public Livro toModel() {

        return new Livro(titulo, resumo, sumario, Double.valueOf(preco),Integer.valueOf(paginas), isbn);
    }
}
