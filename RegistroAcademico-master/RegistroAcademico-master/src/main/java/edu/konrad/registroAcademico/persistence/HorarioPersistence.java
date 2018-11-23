/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.persistence;

import edu.konrad.registroAcademico.entities.HorarioEntity;
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
public class HorarioPersistence {
    
    @PersistenceContext(unitName = "registroAcademicoPU")
    private EntityManager entityManager;

    /**
     * Método que lista todos los elementos que se encuentra en la tabla
     * Horario
     *
     * @return lista de horarios
     */
    public List<HorarioEntity> findAll() {
        Query todos = entityManager.createQuery("select p from Horario p");
        return todos.getResultList();
    }

        /**
         * Método que encuentra un horario por su Id
         *
         * @param id
         * @return horario encontrado
         */
        public HorarioEntity find(Long id){
            HorarioEntity horarioEncontrado = entityManager.find(HorarioEntity.class, id);
            return horarioEncontrado;
        }
        
        /**
         * Este metodo nos permite crear un horario
         * @param horarioCrear
         * @return horarioCrear
         */
        public HorarioEntity create(HorarioEntity horarioCrear){
            entityManager.persist(horarioCrear);
            return horarioCrear;
        }
        
        /**
         * Metodo que nos permite actualizar un horario
         * @param horarioActualizar
         * @return
         */
        public HorarioEntity update(HorarioEntity horarioActualizar){
            entityManager.merge(horarioActualizar);
        return horarioActualizar;
        }
        
        /**
         * Metodo que nos permite eliminar un horario
         * @param id
         */
        public void remove(Long id){
        HorarioEntity horarioEliminar = entityManager.find(HorarioEntity.class, id);
        entityManager.remove(horarioEliminar);
    }
        
}
