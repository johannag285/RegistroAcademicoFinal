/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.resources;

import edu.konrad.registroAcademico.dto.HorarioDTO;
import edu.konrad.registroAcademico.entities.HorarioEntity;
import edu.konrad.registroAcademico.logic.HorarioLogic;
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
@Path("/horarios")
public class HorarioResources {
    
    @EJB
        private HorarioLogic horarioLogic;
    
    /**
     * Metodo REST para obtener todos los horarios
     * @return lista HorarioDTO
     */
    @GET
    public List<HorarioDTO> getListaHorario(){
        List<HorarioEntity> horarios = horarioLogic.getHorarios();
        return HorarioDTO.toListHorario(horarios);
    }
    
    /**
     * Servicio para obtener un horario
     * @param id
     * @return HorarioDTO
     */
    @GET
    @Path("{id: \\d+}")
    public HorarioDTO getHorario(@PathParam("id")Long id){
        HorarioEntity horario = horarioLogic.getHorario(id);
        if (horario == null){
            throw new RuntimeException("El horario NO existe");
        }
        return new HorarioDTO(horario);
    }
    
    /**
     * Servicio para crear un horario
     * @param horarioCrear
     * @return HorarioDTO
     */
    @POST
    public HorarioDTO createHorario(HorarioDTO horarioCrear){
        return new HorarioDTO(horarioLogic.createHorario(horarioCrear.toEntity()));
    }
    
    /**
     * Actualizar un horario
     * @param id
     * @param horarioActualizar
     * @return HorarioDTO
     */
    @PUT
    @Path("{id:\\d+}")
    public HorarioDTO updateHorario(@PathParam("id")Long id, HorarioDTO horarioActualizar){
        HorarioEntity entity = horarioLogic.getHorario(id);
        if(entity == null){
            throw new RuntimeException("El horario NO existe");
        }
        return new HorarioDTO(horarioLogic.update(id, horarioActualizar.toEntity()));
    }
    
    /**
     * Eliminar un horario
     * @param id 
     */
    @DELETE
    @Path("{horariodId:\\d+}")
    public void deleteHorario(@PathParam("horarioId")Long id){
        HorarioEntity horario = horarioLogic.getHorario(id);
        if(horario == null){
            throw new RuntimeException("El horario NO exite");
        }
        horarioLogic.deleteHorario(id);
    }
    
}
