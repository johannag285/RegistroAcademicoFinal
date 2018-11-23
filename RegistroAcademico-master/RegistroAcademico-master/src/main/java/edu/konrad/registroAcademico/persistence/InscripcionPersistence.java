/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.persistence;

import edu.konrad.registroAcademico.entities.InscripcionEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Clase usada para manejar la transaccionalidad de la entidad Inscripcion
 * @author johanna
 */
@Stateless
public class InscripcionPersistence {
    
    @PersistenceContext(unitName = "registroAcademicoPU")
    private EntityManager entityManager;
    
    /**
   * Método que lista todos los elementos que se encuentra en la tabla Inscripcion 
   * @return lista de inscripciones
   */
    
    public List<InscripcionEntity> finAll(){
        Query todos = entityManager.createQuery("select p from Inscripcion p" );
        return todos.getResultList();
    }
    
     /**
     * Método que encuentra una incripcion por su Id
     * @param id
     * @return incripcion encontrada
     */
    
    public InscripcionEntity find(Long id){
        InscripcionEntity inscripcionEncontrada = entityManager.find(InscripcionEntity.class, id);
        return inscripcionEncontrada;
    }
    
    /**
     * Metodo que nos permite crear una Inscrpcion
     * @param inscripcionCrear
     * @return inscripcionCrear
     */
     public InscripcionEntity create(InscripcionEntity inscripcionCrear){
         entityManager.persist(inscripcionCrear);
         return inscripcionCrear;
     }
     
     /**
     * Metodo que nos permite actualizar una Inscripcion
     * @param inscripcionActualizar
     * @return inscripcionActualizar 
     */
     
     public InscripcionEntity update(InscripcionEntity inscripcionActualizar){
         entityManager.merge(inscripcionActualizar);
         return inscripcionActualizar;
     }
     
     /**
     * Metodo que nos permite eleiminar una Inscripcion
     * @param id 
     */
     
     public void remove(Long id){
         InscripcionEntity inscripcionEliminar = entityManager.find(InscripcionEntity.class, id);
         entityManager.remove(inscripcionEliminar);
     }
    
}
