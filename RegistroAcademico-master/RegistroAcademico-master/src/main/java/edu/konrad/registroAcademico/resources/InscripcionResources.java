/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.resources;

import edu.konrad.registroAcademico.dto.InscripcionDTO;
import edu.konrad.registroAcademico.entities.InscripcionEntity;
import edu.konrad.registroAcademico.logic.InscripcionLogic;
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
 * Servicio RES Inscripcion
 * @author johanna
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/inscripciones")
public class InscripcionResources {
    
    @EJB
    private InscripcionLogic inscripcionLogic;
 
     /**
     * Metodo REST para obtener todas las inscripciones
     * @return lista InscripcionDTO
     */
    @GET
    public List<InscripcionDTO> getListaInscripcion(){
        List<InscripcionEntity> inscripcion = inscripcionLogic.getInscripciones();
        return InscripcionDTO.toListInscripcion(inscripcion);
    }
    
    /**
     * Servicio para obtener una inscripcion
     * @param id
     * @return InscripcionDTO
     */
    @GET
    @Path("{id: \\d+}")
    public InscripcionDTO getInscripcion(@PathParam("id") Long id){
        InscripcionEntity inscripcion = inscripcionLogic.getInscripcion(id);
        if(inscripcion == null){
            throw new RuntimeException("La inscripcion no existe");
        }
        return new InscripcionDTO(inscripcion);
    }
    
     /**
     * Servicio para crear una inscripcion
     * @param inscripcionCrear
     * @return InscripcionDTO
     */
    @POST
    public InscripcionDTO createInscripcion(InscripcionDTO inscripcionCrear ){
        return new InscripcionDTO(inscripcionLogic.createInscripcion(inscripcionCrear.toEntity()));
    }
    
     /**
     * Actualizar una isncripcion
     * @param id
     * @param inscripcionActualizar
     * @return inscripcionDTO
     */
    @PUT
    @Path("{Id:\\d+}")
    public InscripcionDTO updateInscripcion(@PathParam("id")Long id, InscripcionDTO inscripcionActualizar){
        InscripcionEntity entity = inscripcionLogic.getInscripcion(id);
        if(entity == null){
            throw new RuntimeException("La inscripcion NO existe");
        }
        return new InscripcionDTO(inscripcionLogic.updateInscripcion(id, inscripcionActualizar.toEntity()));
    }
    /**
     * Eliminar una inscripcion
     * @param id 
     */
    @DELETE
    @Path("{inscripcionId:\\d+}")
    public void deleteInscripcion(@PathParam("inscripcionId")Long id){
        InscripcionEntity ins = inscripcionLogic.getInscripcion(id);
        if(ins == null){
            throw new RuntimeException("La inscripcion NO existe");
        }
        inscripcionLogic.removeInscripcion(id);
    }
}
