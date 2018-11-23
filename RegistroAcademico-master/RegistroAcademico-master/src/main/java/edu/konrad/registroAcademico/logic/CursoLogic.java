/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.logic;

import edu.konrad.registroAcademico.entities.CursoEntity;
import edu.konrad.registroAcademico.persistence.CursoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *Lógica del negocio Curso
 * @author johanna
 */
@Stateless
public class CursoLogic {
    @Inject
    private CursoPersistence cursoPersistence;
    
    /**
     * método que permite obtener todos los cursos
     * @return cursos
     */
    
    public List<CursoEntity> getCursos(){
        List<CursoEntity> cursos = cursoPersistence.finAll();
        return cursos;
    }
    /**
     * método que permite obtener un curso por su id
     * @param id
     * @return curso
     */
    
    public CursoEntity getCurso(Long id){
        CursoEntity curso = cursoPersistence.find(id);
        if(curso == null){
            throw new IllegalArgumentException("El curso que busca no existe ");
        }
        return curso;
    }
    /**
     * método que perimite crear un curso
     * @param cursoEntity
     * @return cursoEntity
     */
    public CursoEntity createCurso(CursoEntity cursoEntity){
        cursoPersistence.create(cursoEntity);
        return cursoEntity;
    }
    /**
     * método que permite actualizar un curso
     * @param id
     * @param cursoEntity
     * @return curso
     * Es necesario volver a tener un objeto de tipo CursoEntity, porque ya recibe uno por parametro 
     */
    
    public CursoEntity updateCurso(Long id, CursoEntity cursoEntity){
        CursoEntity curso = cursoPersistence.update(cursoEntity);
        return curso;
    }
    /**
     * método que permite eliminar un curso
     * @param id 
     */
    public void deleteCurso(Long id){
        cursoPersistence.remove(id);
    }
}
