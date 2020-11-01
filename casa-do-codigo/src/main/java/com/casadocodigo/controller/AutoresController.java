package com.casadocodigo.controller;

import com.casadocodigo.domain.Autor;
import com.casadocodigo.dto.AdicionarAutorDTO;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
//2
@Path("/autores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AutoresController {

    @GET
    @Transactional
    public List<Autor> buscar() {
        return Autor.findAll().list();
    }

    @POST
    @Transactional
    //1
    //2
    public void adicionar(@Valid AdicionarAutorDTO request) {
        //1
        Autor autor = request.converter();
        autor.persist();
    }
}