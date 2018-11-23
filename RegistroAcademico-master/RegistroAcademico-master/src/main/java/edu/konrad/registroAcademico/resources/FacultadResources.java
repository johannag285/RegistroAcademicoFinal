/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.resources;

import edu.konrad.registroAcademico.dto.FacultadDTO;
import edu.konrad.registroAcademico.entities.FacultadEntity;
import edu.konrad.registroAcademico.logic.FacultadLogic;
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
@Path("/facultades")
public class FacultadResources {
    
    @EJB
        private FacultadLogic facultadLogic;
    
    /**
     * Metodo REST para obtener todas las facultades
     * @return lista FacultadDTO
     */
    @GET
    public List<FacultadDTO> getListaFacultad(){
        List<FacultadEntity> facultades = facultadLogic.getFacultades();
        return FacultadDTO.toListFacultad(facultades);
    }
    
    /**
     * Servicio para obtener una facultad
     * @param id
     * @return FacultadDTO
     */
    @GET
    @Path("{id: \\d+}")
    public FacultadDTO getFacultad(@PathParam("id")Long id){
        FacultadEntity facultad = facultadLogic.getFacultad(id);
        if (facultad == null){
            throw new RuntimeException("La facultad NO existe");
        }
        return new FacultadDTO(facultad);
    }
    
    /**
     * Servicio para crear una facultad
     * @param facultadCrear
     * @return FacultadDTO
     */
    @POST
    public FacultadDTO createFacultad(FacultadDTO facultadCrear){
        return new FacultadDTO(facultadLogic.createFacultad(facultadCrear.toEntity()));
    }
    
    /**
     * Actualizar una facultad
     * @param id
     * @param facultadActualizar
     * @return FacultadDTO
     */
    @PUT
    @Path("{id:\\d+}")
    public FacultadDTO updateFacultad(@PathParam("id")Long id, FacultadDTO facultadActualizar){
        FacultadEntity entity = facultadLogic.getFacultad(id);
        if(entity == null){
            throw new RuntimeException("La facultad NO existe");
        }
        return new FacultadDTO(facultadLogic.update(id, facultadActualizar.toEntity()));
    }
    
    /**
     * Eliminar una facultad
     * @param id 
     */
    @DELETE
    @Path("{facultadId:\\d+}")
    public void deleteFacultad(@PathParam("facultadId")Long id){
        FacultadEntity facultad = facultadLogic.getFacultad(id);
        if(facultad == null){
            throw new RuntimeException("La facultad NO exite");
        }
        facultadLogic.deleteFacultad(id);
    }
}
