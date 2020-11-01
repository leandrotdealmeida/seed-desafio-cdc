package com.casadocodigo.controller;

import com.casadocodigo.domain.Autor;
import com.casadocodigo.dto.AdicionarAutorDTO;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/autor")
public class AutorController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Autor> findAll() {
        return Autor.findAll().list();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public void cadastrar(@Valid AdicionarAutorDTO request) {
        Autor autor = new Autor(request);
        autor.persist();
    }
}