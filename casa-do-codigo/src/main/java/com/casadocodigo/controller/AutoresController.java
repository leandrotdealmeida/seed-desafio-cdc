package com.casadocodigo.controller;

import com.casadocodigo.domain.Autor;
import com.casadocodigo.dto.AutorResponse;
import com.casadocodigo.dto.NovoAutorRequest;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;
import java.util.stream.Collectors;

//2
@Path("/autores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AutoresController {

    @GET
    @Transactional
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
        autor.persist();
        return Response.status(Status.CREATED).build();
    }
}