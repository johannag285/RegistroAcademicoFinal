/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.resources;

import edu.konrad.registroAcademico.dto.CursoDTO;
import edu.konrad.registroAcademico.entities.CursoEntity;
import edu.konrad.registroAcademico.logic.CursoLogic;
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
 * Servicio REST Curso
 * @author johanna
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/cursos")
public class CursoResources {
    
    @EJB
    private CursoLogic cursoLogic;
    
     /**
     * Metodo REST para obtener todos los cursos
     * @return lista CursoDTO
     */
    @GET
    public List<CursoDTO> getListaCurso(){
        List<CursoEntity> curso = cursoLogic.getCursos();
        return CursoDTO.toListCurso(curso);
    }
    
     /**
     * Servicio para obtener un curso
     * @param id
     * @return CursoDTO
     */
    @GET
    @Path("{id: \\d+}")
    public CursoDTO getCurso(@PathParam("id")Long id){
        CursoEntity curso = cursoLogic.getCurso(id);
        if (curso == null){
            throw new RuntimeException("El curso NO existe");
        }
        return new CursoDTO(curso);
    }
    
    /**
     * Servicio para crear un curso
     * @param cursoCrear
     * @return CursoDTO
     */
    @POST
    public CursoDTO createCurso(CursoDTO cursoCrear){
        return new CursoDTO(cursoLogic.createCurso(cursoCrear.toEntity()));
    }
    
     /**
     * Actualizar un curso
     * @param id
     * @param cursoActualizar
     * @return CursoDTO
     */
    @PUT
    @Path("{id:\\d+}")
    public CursoDTO updateCurso(@PathParam("id")Long id, CursoDTO cursoActualizar){
        CursoEntity entity = cursoLogic.getCurso(id);
        if(entity == null){
            throw new RuntimeException("El curso NO existe");
        }
        return new CursoDTO(cursoLogic.updateCurso(id, cursoActualizar.toEntity()));
    }
    
    /**
     * Eliminar un curso
     * @param id 
     */
    @DELETE
    @Path("{cursoId:\\d+}")
    public void deleteCurso(@PathParam("cursoId")Long id){
        CursoEntity curso = cursoLogic.getCurso(id);
        if(curso == null){
            throw new RuntimeException("El curso NO exite");
        }
        cursoLogic.deleteCurso(id);
    }
}
