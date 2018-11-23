/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.resources;

import edu.konrad.registroAcademico.dto.EstudianteDTO;
import edu.konrad.registroAcademico.entities.EstudianteEntity;
import edu.konrad.registroAcademico.logic.EstudianteLogic;
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
 * Servicio REST Estudiante
 *
 * @author Daniela CH
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/estudiantes")
public class EstudianteResources {

    @EJB
    private EstudianteLogic estudianteLogic;

    /**
     * Metodo REST para obtener todos los estudiantes
     * @return Lista EstudianteDTO
     */
    @GET
    public List<EstudianteDTO> getListaEstudiante() {
        List<EstudianteEntity> estudiantes = estudianteLogic.getEstudiante();
        return EstudianteDTO.toListEstudiante(estudiantes);
    }

    /**
     * Servicio para obtener un estudiante
     * @param id
     * @return EstudianteDTO
     */
    @GET
    @Path("{id: \\d+}")
    public EstudianteDTO getEstudiante(@PathParam("id") Long id) {
        EstudianteEntity estudiante = estudianteLogic.getEstudiante(id);
        if (estudiante == null) {
            throw new RuntimeException("El estudiante NO existe");
        }
        return new EstudianteDTO(estudiante);
    }

    /**
     * Servicio para crear un estudiante
     * @param estudianteCrear
     * @return EstudianteDTO
     */
    @POST
    public EstudianteDTO createEstudiante(EstudianteDTO estudianteCrear) {
        return new EstudianteDTO(estudianteLogic.createEstudiante(estudianteCrear.toEntity()));
    }

    /**
     * Actualizar un estudiante
     * @param id
     * @param estudianteActualizar
     * @return EstudianteDTO
     */
    @PUT
    @Path("{id:\\d+}")
    public EstudianteDTO updateEstudiante(@PathParam("id") Long id, EstudianteDTO estudianteActualizar) {
        EstudianteEntity entity = estudianteLogic.getEstudiante(id);
        if (entity == null) {
            throw new RuntimeException("El estudiante NO existe");
        }
        return new EstudianteDTO(estudianteLogic.updateEstudiante(id, estudianteActualizar.toEntity()));
    }

    /**
     * Eliminar estudiante
     * @param id
     */
    @DELETE
    @Path("{estudianteId:\\d+}")
    public void deleteEstudiante(@PathParam("estudianteId") Long id) {
        EstudianteEntity estudiante = estudianteLogic.getEstudiante(id);
        if (estudiante == null) {
            throw new RuntimeException("El estudiante NO exite");
        }
        estudianteLogic.removeEstudiante(id);
    }
}
