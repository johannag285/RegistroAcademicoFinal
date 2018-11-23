/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.logic;


import edu.konrad.registroAcademico.entities.PersonaEntity;
import edu.konrad.registroAcademico.persistence.PersonaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *Lógica del negocio Persona
 * @author johanna
 */
@Stateless
public class PersonaLogic {
    
    @Inject
    private PersonaPersistence personaPersistence;
    
     /**
      * método que permite Obtener el listado de personas 
      * @return personas
      */
    
    public List<PersonaEntity> getPersonas(){
        List<PersonaEntity> personas = personaPersistence.findAll();
        return personas;
    }
    
     /**
      * método que permite Obtener una persona a traves de su Id
      * @param Id
      * @return persona
      */
    
    public PersonaEntity getPersona (Long Id){
        PersonaEntity persona = personaPersistence.find(Id);
        if (persona == null){
            throw new IllegalArgumentException("La persona que busca no existe");
        }
        return persona;
    }
     /**
      * método que permite Crear una nueva persona 
      * @param personaEntity
      * @return personaEntity
      */
    
    public PersonaEntity createPersona(PersonaEntity personaEntity){
        personaPersistence.create(personaEntity);
        return personaEntity;
    }
     /**
      * método que permite Actualizar persona
      * @param id
      * @param personaEntity
      * @return persona
      */
    
    public PersonaEntity update(Long id, PersonaEntity personaEntity){
        PersonaEntity persona = personaPersistence.update(personaEntity);
        return persona;
    }
     /**
      * método que permite Eliminar Persona por su Id
      * @param id 
      */
    public void deletePersona(Long id){
        personaPersistence.remove(id);
    }
}
