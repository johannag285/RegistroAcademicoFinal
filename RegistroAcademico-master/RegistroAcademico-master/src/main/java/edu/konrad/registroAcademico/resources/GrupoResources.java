/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.resources;

import edu.konrad.registroAcademico.dto.GrupoDTO;
import edu.konrad.registroAcademico.entities.GrupoEntity;
import edu.konrad.registroAcademico.logic.GrupoLogic;
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
 * Servicio REST Grupo
 *
 * @author Daniela CH
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/grupos")
public class GrupoResources {
    @EJB
    private GrupoLogic grupoLogic;
    
    /**
     * Metodo REST para obtener todos los Grupos
     * @return lista GrupoDTO
     */
    @GET
    public List<GrupoDTO> getListaGrupo(){
        List<GrupoEntity> grupos = grupoLogic.getGrupo();
        return GrupoDTO.toListGrupo(grupos);
    }
    
    /**
     * Servicio para obtener un Grupo
     * @param id
     * @return GrupoDTO
     */
    @GET
    @Path("{id: \\d+}")
    public GrupoDTO getGrupo(@PathParam("id")Long id){
        GrupoEntity grupo = grupoLogic.getGrupo(id);
        if (grupo == null){
            throw new RuntimeException("El grupo NO existe");
        }
        return new GrupoDTO(grupo);
    }
    /**
     * Servicio para crear un grupo
     * @param grupoCrear
     * @return GrupoDTO
     */  
    @POST
    public GrupoDTO createGrupo(GrupoDTO grupoCrear){
        return new GrupoDTO(grupoLogic.createGrupo(grupoCrear.toEntity()));
    }
    
    /**
     * Actualizar un Grupo
     * @param id
     * @param grupoActualizar
     * @return GrupoDTO
     */
   @PUT
    @Path("{id:\\d+}")
    public GrupoDTO updateGrupo(@PathParam("id") Long id, GrupoDTO grupoActualizar) {
        GrupoEntity entity = grupoLogic.getGrupo(id);
        if (entity == null) {
            throw new RuntimeException("El grupo NO existe");
        }
        return new GrupoDTO(grupoLogic.updateGrupo(id, grupoActualizar.toEntity()));
    }
    
    /**
     * Eliminar un Grupo
     * @param id 
     */
    @DELETE
    @Path("{grupoId:\\d+}")
    public void deleteGrupo(@PathParam("grupoId")Long id){
        GrupoEntity grupo = grupoLogic.getGrupo(id);
        if(grupo == null){
            throw new RuntimeException("El grupo NO exite");
        }
        grupoLogic.removeGrupo(id);
    }
}


    

