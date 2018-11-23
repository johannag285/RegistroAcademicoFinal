/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.logic;

import edu.konrad.registroAcademico.entities.ProfesorEntity;
import edu.konrad.registroAcademico.persistence.ProfesorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Carlos David
 */
@Stateless
public class ProfesorLogic {
    
    @Inject
    private ProfesorPersistence profesorPersistence;
    
    /**
      * método que permite Obtener el listado de profesores
      * @return profesores
      */
    public List<ProfesorEntity> getProfesores(){
        List<ProfesorEntity> profesores = profesorPersistence.findAll();
        return profesores;
    }
    
    /**
      * método que permite Obtener un profesor a traves de su Id
      * @param Id
      * @return profesor
      */
    public ProfesorEntity getProfesor (Long Id){
        ProfesorEntity profesor = profesorPersistence.find(Id);
        if (profesor == null){
            throw new IllegalArgumentException("El profesor que busca no existe");
        }
        return profesor;
    }
    
    /**
      * método que permite Crear un nuevo profesor
      * @param profesorEntity
      * @return profesorEntity
      */
    public ProfesorEntity createProfesor(ProfesorEntity profesorEntity){
        profesorPersistence.create(profesorEntity);
        return profesorEntity;
    }
    
    /**
      * método que permite Actualizar profesor
      * @param id
      * @param profesorEntity
      * @return facultad
      */
    public ProfesorEntity update(Long id, ProfesorEntity profesorEntity){
        ProfesorEntity profesor = profesorPersistence.update(profesorEntity);
        return profesor;
    }
    
    /**
      * método que permite Eliminar un profesor por su Id
      * @param id 
      */
    public void deleteProfesor(Long id){
        profesorPersistence.remove(id);
    }
    
}
