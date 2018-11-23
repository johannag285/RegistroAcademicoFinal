/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.logic;

import edu.konrad.registroAcademico.entities.FacultadEntity;
import edu.konrad.registroAcademico.persistence.FacultadPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Carlos David
 */
@Stateless
public class FacultadLogic {
    
    @Inject
    private FacultadPersistence facultadPersistence;
    
    /**
      * método que permite Obtener el listado de facultades
      * @return facultades
      */
    public List<FacultadEntity> getFacultades(){
        List<FacultadEntity> facultades = facultadPersistence.findAll();
        return facultades;
    }
    
    /**
      * método que permite Obtener una facultad a traves de su Id
      * @param Id
      * @return facultad
      */
    public FacultadEntity getFacultad (Long Id){
        FacultadEntity facultad = facultadPersistence.find(Id);
        if (facultad == null){
            throw new IllegalArgumentException("La persona que busca no existe");
        }
        return facultad;
    }
    
    /**
      * método que permite Crear una nueva facultad
      * @param facultadEntity
      * @return facultadEntity
      */
    public FacultadEntity createFacultad(FacultadEntity facultadEntity){
        facultadPersistence.create(facultadEntity);
        return facultadEntity;
    }
    
    /**
      * método que permite Actualizar facultad
      * @param id
      * @param facultadEntity
      * @return facultad
      */
    public FacultadEntity update(Long id, FacultadEntity facultadEntity){
        FacultadEntity facultad = facultadPersistence.update(facultadEntity);
        return facultad;
    }
    
    /**
      * método que permite Eliminar una facultad por su Id
      * @param id 
      */
    public void deleteFacultad(Long id){
        facultadPersistence.remove(id);
    }
}
