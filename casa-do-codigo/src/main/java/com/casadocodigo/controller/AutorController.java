package com.casadocodigo.controller;

import com.casadocodigo.domain.Autor;
import com.casadocodigo.dto.AdicionarAutorDTO;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/autores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AutorController {

    @GET
    @Transactional
    public List<Autor> buscar() {
        return Autor.findAll().list();
    }

    @POST
    @Transactional
    public void adicionar(@Valid AdicionarAutorDTO request) {
        Autor autor = request.converter();
        autor.persist();
    }
}