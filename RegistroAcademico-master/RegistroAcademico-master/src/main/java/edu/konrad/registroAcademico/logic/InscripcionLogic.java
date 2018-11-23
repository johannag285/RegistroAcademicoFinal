/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.logic;

import edu.konrad.registroAcademico.entities.InscripcionEntity;
import edu.konrad.registroAcademico.persistence.InscripcionPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *Lógica del negocio de Inscripcion
 * @author johanna
 */
@Stateless
public class InscripcionLogic {
   
    @Inject
    private InscripcionPersistence inscripcionPersistence;
    
    /**
     * método que permite obtener la lista de inscripciones
     * @return inscripciones
     */
    
    public List<InscripcionEntity> getInscripciones(){
        List<InscripcionEntity> inscripciones = inscripcionPersistence.finAll();
        return inscripciones;
    }
    /**
     * método que permite obtener la inscripcion por su id
     * @param id
     * @return inscripcion
     */
    public InscripcionEntity getInscripcion(Long id){
        InscripcionEntity inscripcion = inscripcionPersistence.find(id);
        if(inscripcion == null){
            throw new IllegalArgumentException("La inscripcion que busca no existe");
        }
        return inscripcion;
    }
    /**
     * método que permite crear una inscripcion
     * @param inscripcionEntity
     * @return inscripcionEntity
     */
    public InscripcionEntity createInscripcion(InscripcionEntity inscripcionEntity){
        inscripcionPersistence.create(inscripcionEntity);
        return inscripcionEntity;
    }
    /**
     * método que permite actualizar una inscripcion
     * @param id
     * @param inscripcionEntity
     * @return inscripcion
     */
    public InscripcionEntity updateInscripcion(Long id, InscripcionEntity inscripcionEntity){
        InscripcionEntity inscripcion = inscripcionPersistence.update(inscripcionEntity);
        return inscripcion;
    }
    /**
     * método que permite eliminar una inscripcion
     * @param id 
     */
    public void removeInscripcion(Long id){
        inscripcionPersistence.remove(id);
    }
}
