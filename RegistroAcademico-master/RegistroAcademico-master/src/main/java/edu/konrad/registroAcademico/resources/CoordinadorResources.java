/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.resources;

import edu.konrad.registroAcademico.dto.CoordinadorDTO;
import edu.konrad.registroAcademico.entities.CoordinadorEntity;
import edu.konrad.registroAcademico.logic.CoordinadorLogic;

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
 * Servicio REST Coordinador
 * @author johanna
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/coordinadores")
public class CoordinadorResources {
    
    @EJB
    private CoordinadorLogic coordinadorLogic;
    
    /**
     * Metodo REST para obtener todos los coordinadores
     * @return lista CoordinadorDTO
     */
    @GET
    public List<CoordinadorDTO> getListaCoordinador(){
        List<CoordinadorEntity> coordinadores = coordinadorLogic.getCoordinadores();
        return CoordinadorDTO.toListCoordinador(coordinadores);
    }
    
     /**
     * Servicio para obtener un coordinador
     * @param id
     * @return CoordinadorDTO
     */
    @GET
    @Path("{id: \\d+}")
    public CoordinadorDTO getCoordinador(@PathParam("id")Long id){
        CoordinadorEntity coordinador = coordinadorLogic.getCoordinador(id);
        if (coordinador == null){
            throw new RuntimeException("El coordinador NO existe");
        }
        return new CoordinadorDTO(coordinador);
    }
    
    /**
     * Servicio para crear un coordinador
     * @param coordinadorCrear
     * @return CoordinadorDTO
     */
    @POST
    public CoordinadorDTO createCoordinador(CoordinadorDTO coordinadorCrear){
        return new CoordinadorDTO(coordinadorLogic.createCoordinador(coordinadorCrear.toEntity()));
    }
    
      /**
     * Actualizar un coordinador
     * @param id
     * @param coordinadorActualizar
     * @return CoordinadorDTO
     */
    @PUT
    @Path("{id:\\d+}")
    public CoordinadorDTO updateCoordinador(@PathParam("id")Long id, CoordinadorDTO coordinadorActualizar){
        CoordinadorEntity entity = coordinadorLogic.getCoordinador(id);
        if(entity == null){
            throw new RuntimeException("El coordiandor NO existe");
        }
        return new CoordinadorDTO(coordinadorLogic.updateCoordinador(id, coordinadorActualizar.toEntity()));
    }
    
    /**
     * Eliminar una persona
     * @param id 
     */
    @DELETE
    @Path("{coordinadorId:\\d+}")
    public void deleteCoordinador(@PathParam("coordinadorId")Long id){
        CoordinadorEntity coordinador = coordinadorLogic.getCoordinador(id);
        if(coordinador == null){
            throw new RuntimeException("El coordinador NO exite");
        }
        coordinadorLogic.removeCoordinador(id);
    }
}
