/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.persistence;

import edu.konrad.registroAcademico.entities.PersonaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase usada para manejar la transaccionalidad de la entidad Persona
 * @author johanna
 */
@Stateless
public class PersonaPersistence {
    @PersistenceContext(unitName = "registroAcademicoPU")
    private EntityManager entityManager;
    
  /**
   * Método que lista todos los elementos que se encuentra en la tabla Persona 
   * @return lista de personas
   */  
    
    public List<PersonaEntity> findAll(){
        Query todos = entityManager.createQuery("select p from Persona p");
        return todos.getResultList();
    }
    
    
    /**
     * Método que encuentra una persona por su Id
     * @param id
     * @return perosna encontrada
     */
    public PersonaEntity find(Long id){
        PersonaEntity personaEncontrada = entityManager.find(PersonaEntity.class, id);
        return personaEncontrada;
    }
    
    /**
     * Metodo que nos permite crear una Persona
     * @param personaCrear
     * @return personaCrear
     */
    public PersonaEntity create(PersonaEntity personaCrear){
        entityManager.persist(personaCrear);
        return personaCrear;
    }
    
    /**
     * Metodo que nos permite actualizar una Persona 
     * @param personaActualizar
     * @return 
     */
    public PersonaEntity update(PersonaEntity personaActualizar){
        entityManager.merge(personaActualizar);
        return personaActualizar;
    }
    
    /**
     * Metodo que nos permite eleiminar una Persona
     * @param id 
     */
    public void remove(Long id){
        PersonaEntity personaEliminar = entityManager.find(PersonaEntity.class, id);
        entityManager.remove(personaEliminar);
    }
}
