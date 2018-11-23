/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.persistence;

import edu.konrad.registroAcademico.entities.CoordinadorEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *Clase usada para manejar la transaccionalidad de la entidad Coordinador.
 * @author johanna
 */
@Stateless
public class CoordinadorPersistence {
  @PersistenceContext(unitName="registroAcademicoPU")
  private EntityManager entityManager;
  
  
  /**
   * Método que lista todos los elementos que se encuentra en la tabla Coordinador 
   * @return lista de coordiandores
   */
  
   public List<CoordinadorEntity> findAll(){
        Query todos = entityManager.createQuery("select p from Coordinador p");
        return todos.getResultList();
    }
   
   /**
     * Método que encuentra a un coordiandor por su Id
     * @param id
     * @return coordinador encontrado
     */
   
   public CoordinadorEntity find(Long id){
       CoordinadorEntity coordinadorEncontrado = entityManager.find(CoordinadorEntity.class, id);
       return coordinadorEncontrado;
   }
   
    /**
     * Metodo que nos permite crear un Coordinador
     * @param coordinadorCrear
     * @return coordinadorCrear
     */
   
   public CoordinadorEntity create (CoordinadorEntity coordinadorCrear){
       entityManager.persist(coordinadorCrear);
       return coordinadorCrear;
   }
   
   /**
     * Metodo que nos permite actualizar un Coordinador
     * @param coordinadorActualizar
     * @return coordinadorActualizar  
     */
   
   public CoordinadorEntity update(CoordinadorEntity coordinadorActualizar){
       entityManager.merge(coordinadorActualizar);
       return coordinadorActualizar;
   }
   
   /**
     * Metodo que nos permite eleiminar un Coordinador
     * @param id 
     */
   
   public void remove(Long id){
       CoordinadorEntity coordinadorEliminar = entityManager.find(CoordinadorEntity.class, id);
       entityManager.remove(coordinadorEliminar);
   }
}
