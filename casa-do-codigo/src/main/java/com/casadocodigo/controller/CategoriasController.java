package com.casadocodigo.controller;
import com.casadocodigo.domain.Categoria;
import com.casadocodigo.dto.NovaCategoriaRequest;

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

@Path("/categorias")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoriasController {

    @Inject
    Validator validator;

    @GET
    public List<Categoria> buscar() {
        return Categoria.listAll();
    }

    @POST
    @Transactional
    public Response adicionar(@Valid NovaCategoriaRequest request, Function<Set<ConstraintViolation<Categoria>>, Response> retornarErros) {

        Categoria categoria = request.toModel();
        Set<ConstraintViolation<Categoria>> violations = validator.validate(categoria);
        
        if (violations.isEmpty()) {
            categoria.persist();
            return Response.status(Status.CREATED).build();
        } else {
            return retornarErros.apply(violations);
        }

    }
}
