/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.resources;

import edu.konrad.registroAcademico.dto.ProfesorDTO;
import edu.konrad.registroAcademico.entities.ProfesorEntity;
import edu.konrad.registroAcademico.logic.ProfesorLogic;
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
 *
 * @author Carlos David
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/profesores")
public class ProfesorResources {
    
    @EJB
        private ProfesorLogic profesorLogic;
    
    /**
     * Metodo REST para obtener todos los profesores
     * @return lista ProfesorDTO
     */
    @GET
    public List<ProfesorDTO> getListaProfesor(){
        List<ProfesorEntity> profesores = profesorLogic.getProfesores();
        return ProfesorDTO.toListProfesor(profesores);
    }
    
    /**
     * Servicio para obtener un profesor
     * @param id
     * @return ProfesorDTO
     */
    @GET
    @Path("{id: \\d+}")
    public ProfesorDTO getProfesor(@PathParam("id")Long id){
        ProfesorEntity profesor = profesorLogic.getProfesor(id);
        if (profesor == null){
            throw new RuntimeException("El profesor NO existe");
        }
        return new ProfesorDTO(profesor);
    }
    
    /**
     * Servicio para crear un profesor
     * @param profesorCrear
     * @return ProfesorDTO
     */
    @POST
    public ProfesorDTO createProfesor(ProfesorDTO profesorCrear){
        return new ProfesorDTO(profesorLogic.createProfesor(profesorCrear.toEntity()));
    }
    
    /**
     * Actualizar un profesor
     * @param id
     * @param profesorActualizar
     * @return ProfesorDTO
     */
    @PUT
    @Path("{id:\\d+}")
    public ProfesorDTO updateProfesor(@PathParam("id")Long id, ProfesorDTO profesorActualizar){
        ProfesorEntity entity = profesorLogic.getProfesor(id);
        if(entity == null){
            throw new RuntimeException("El profesor NO existe");
        }
        return new ProfesorDTO(profesorLogic.update(id, profesorActualizar.toEntity()));
    }
    
    /**
     * Eliminar un profesor
     * @param id 
     */
    @DELETE
    @Path("{profesorId:\\d+}")
    public void deleteProfesor(@PathParam("profesorId")Long id){
        ProfesorEntity profesor = profesorLogic.getProfesor(id);
        if(profesor == null){
            throw new RuntimeException("El profesor NO exite");
        }
        profesorLogic.deleteProfesor(id);
    }
    
}
