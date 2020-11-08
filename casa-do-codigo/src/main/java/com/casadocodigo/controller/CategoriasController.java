package com.casadocodigo.controller;

import com.casadocodigo.domain.Autor;
import com.casadocodigo.domain.Categoria;
import com.casadocodigo.dto.NovaCategoriaRequest;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

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
    public Response adicionar(@Valid NovaCategoriaRequest request) {

        Categoria categoria = request.toModel();
        Set<ConstraintViolation<Categoria>> violations = validator.validate(categoria);
        if (violations.isEmpty()) {
            categoria.persist();
            return Response.ok().build();
        } else {
            JsonArrayBuilder errors = Json.createArrayBuilder();
            for (ConstraintViolation<Categoria> violation : violations) {
                errors.add(
                        Json.createObjectBuilder()
                                .add("path", violation.getPropertyPath().toString())
                                .add("message", violation.getMessage())
                );
            }

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(errors.build())
                    .build();
        }

    }
}
