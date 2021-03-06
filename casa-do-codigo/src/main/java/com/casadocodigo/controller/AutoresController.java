package com.casadocodigo.controller;

import com.casadocodigo.domain.Autor;
import com.casadocodigo.dto.AutorResponse;
import com.casadocodigo.dto.NovoAutorRequest;

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
import javax.ws.rs.core.Response.Status;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//2
@Path("/autores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AutoresController {

    @Inject
    Validator validator;

    @GET
    public List<AutorResponse> buscar() {
        return Autor.streamAll().map(a -> new AutorResponse((Autor) a)).collect(Collectors.toList());
    }

    @POST
    @Transactional
    //1
    //2
    public Response adicionar(@Valid NovoAutorRequest request) {
        //1
        Autor autor = request.toModel();
        Set<ConstraintViolation<Autor>> violations = validator.validate(autor);

        if (violations.isEmpty()) {
            autor.persist();
            return Response.status(Status.CREATED).build();
        } else {
            JsonArrayBuilder errors = Json.createArrayBuilder();
            for (ConstraintViolation<Autor> violation : violations) {
                errors.add(
                        Json.createObjectBuilder()
                                .add("path", violation.getPropertyPath().toString())
                                .add("message", violation.getMessage())
                );
            }
            return Response.status(Status.BAD_REQUEST)
                    .entity(errors.build())
                    .build();
        }
    }
}