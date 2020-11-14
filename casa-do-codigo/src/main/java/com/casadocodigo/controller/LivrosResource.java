package com.casadocodigo.controller;
import com.casadocodigo.domain.Livro;
import com.casadocodigo.dto.NovoLivroRequest;

import javax.inject.Inject;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

@Path("/livros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LivrosResource {

    @Inject
    Validator validator;

    @GET
    public List<Livro> buscar() {
        return Livro.listAll();
    }

    @POST
    @Transactional
    public Response cadastrarLivro(@Valid NovoLivroRequest request, Function<Set<ConstraintViolation<Livro>>, Response> function) {

        Livro livro = request.toModel();
        Set<ConstraintViolation<Livro>> violations = validator.validate(livro);

        if (violations.isEmpty()) {
            livro.persist();
            return Response.status(Status.CREATED).build();

        } else {
            return function.apply(violations);

        }
    }
}
