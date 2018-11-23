/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.resources;

import edu.konrad.registroAcademico.dto.ProgramaDTO;
import edu.konrad.registroAcademico.entities.ProgramaEntity;
import edu.konrad.registroAcademico.logic.ProgramaLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Servicio REST Programa
 *
 * @author Daniela CH
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/programas")
public class ProgramaResources {
    @EJB
    private ProgramaLogic programaLogic;

    /**
     * Metodo REST para obtener todos los programas
     * @return Lista ProgramaDTO
     */
    @GET
    public List<ProgramaDTO> getListaPrograma() {
        List<ProgramaEntity> programas = programaLogic.getPrograma();
        return ProgramaDTO.toListPrograma(programas);
    }

    /**
     * Servicio para obtener un programa
     * @param id
     * @return ProgramaDTO
     */
    @GET
    @Path("{id: \\d+}")
    public ProgramaDTO getPrograma(@PathParam("id") Long id) {
        ProgramaEntity programa = programaLogic.getPrograma(id);
        if (programa == null) {
            throw new RuntimeException("El programa NO existe");
        }
        return new ProgramaDTO(programa);
    }

    /**
     * Servicio para crear un programa
     * @param programaCrear
     * @return ProgramaDTO
     */
    @POST
    public ProgramaDTO createPrograma(ProgramaDTO programaCrear) {
        return new ProgramaDTO(programaLogic.createPrograma(programaCrear.toEntity()));
    }

    /**
     * Actualizar un programa
     * @param id
     * @param programaActualizar
     * @return ProgramaDTO
     */
    @PUT
    @Path("{id:\\d+}")
    public ProgramaDTO updatePrograma(@PathParam("id") Long id, ProgramaDTO programaActualizar) {
        ProgramaEntity entity = programaLogic.getPrograma(id);
        if (entity == null) {
            throw new RuntimeException("El programa NO existe");
        }
        return new ProgramaDTO(programaLogic.updatePrograma(id, programaActualizar.toEntity()));
    }

    /**
     * Eliminar un programa
     * @param id
     */
    @DELETE
    @Path("{programaId:\\d+}")
    public void deletePrograma(@PathParam("programaId") Long id) {
        ProgramaEntity programa = programaLogic.getPrograma(id);
        if (programa == null) {
            throw new RuntimeException("El programa NO exite");
        }
        programaLogic.removePrograma(id);
    }
    
}
