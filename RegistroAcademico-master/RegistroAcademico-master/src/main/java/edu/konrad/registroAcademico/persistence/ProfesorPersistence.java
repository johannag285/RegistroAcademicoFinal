/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.persistence;

import edu.konrad.registroAcademico.entities.ProfesorEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Carlos David
 */
@Stateless
public class ProfesorPersistence {
    
    @PersistenceContext(unitName = "registroAcademicoPU")
    private EntityManager entityManager;

    /**
     * Método que lista todos los elementos que se encuentra en la tabla
     * Profesor
     *
     * @return lista de profesor
     */
    public List<ProfesorEntity> findAll() {
        Query todos = entityManager.createQuery("select p from Profesor p");
        return todos.getResultList();
    }

        /**
         * Método que encuentra un profesor por su Id
         *
         * @param id
         * @return profesor encontrado
         */
        public ProfesorEntity find(Long id){
            ProfesorEntity profesorEncontrado = entityManager.find(ProfesorEntity.class, id);
            return profesorEncontrado;
        }
        
        /**
         * Este metodo nos permite crear un profesor
         * @param profesorCrear
         * @return profesorCrear
         */
        public ProfesorEntity create(ProfesorEntity profesorCrear){
            entityManager.persist(profesorCrear);
            return profesorCrear;
        }
        
        /**
         * Metodo que nos permite actualizar un profesor
         * @param profesorActualizar
         * @return
         */
        public ProfesorEntity update(ProfesorEntity profesorActualizar){
            entityManager.merge(profesorActualizar);
        return profesorActualizar;
        }
        
        /**
         * Metodo que nos permite eliminar un profesor
         * @param id
         */
        public void remove(Long id){
        ProfesorEntity profesorEliminar = entityManager.find(ProfesorEntity.class, id);
        entityManager.remove(profesorEliminar);
    }
        
}
