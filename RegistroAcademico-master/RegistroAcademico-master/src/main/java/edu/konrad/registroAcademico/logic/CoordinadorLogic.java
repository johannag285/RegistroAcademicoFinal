/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.logic;

import edu.konrad.registroAcademico.entities.CoordinadorEntity;
import edu.konrad.registroAcademico.persistence.CoordinadorPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *Lógica del negocio Coordinador
 * @author johanna
 */

@Stateless
public class CoordinadorLogic {
    
    @Inject
    private CoordinadorPersistence coordinadorPersistence;
    
     /**
      * método que permite Obtener la lista de coordinadores
      * @return coordiandores
      */
    
    public List<CoordinadorEntity> getCoordinadores(){
        List<CoordinadorEntity> coordinadores = coordinadorPersistence.findAll();
        return coordinadores;
    }
    
     /**
      * método que permite Obtener el coordinador por su Id
      * @param id
      * @return coordinador 
      */
    
    public CoordinadorEntity getCoordinador(Long id){
        CoordinadorEntity coordinador = coordinadorPersistence.find(id);
        if(coordinador == null){
            throw new IllegalArgumentException("El coordinador que busca no existe");
        }
        return coordinador;
    }
    
    /**
     * método que permite Crear un nuevo coordinador
     * @param coordinadorEntity
     * @return coordinadorEntity
     */
    
    public CoordinadorEntity createCoordinador(CoordinadorEntity coordinadorEntity){
        coordinadorPersistence.create(coordinadorEntity);
        return coordinadorEntity;
    }
    /**
     * método que permite Actualizar un coordinador
     * @param id
     * @param coordinadorEntity
     * @return coordinador
     */
    public CoordinadorEntity updateCoordinador(Long id,CoordinadorEntity coordinadorEntity){
        CoordinadorEntity coordinador = coordinadorPersistence.update(coordinadorEntity);
        return coordinador;
    }
    
    /**
     * método que permite eliminar un coordinador por su id
     * @param id 
     */
    
    public void removeCoordinador(Long id){
        coordinadorPersistence.remove(id);
    }
}
