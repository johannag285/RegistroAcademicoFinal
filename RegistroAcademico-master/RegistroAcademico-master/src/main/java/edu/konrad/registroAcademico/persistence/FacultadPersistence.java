/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.persistence;

import edu.konrad.registroAcademico.entities.FacultadEntity;
import edu.konrad.registroAcademico.entities.PersonaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase usada para manejar la transaccionalidad de la entidad Facultad
 *
 * @author Carlos David
 */
@Stateless
public class FacultadPersistence {

    @PersistenceContext(unitName = "registroAcademicoPU")
    private EntityManager entityManager;

    /**
     * Método que lista todos los elementos que se encuentra en la tabla
     * Facultad
     *
     * @return lista de facultades
     */
    public List<FacultadEntity> findAll() {
        Query todos = entityManager.createQuery("select p from Facultad p");
        return todos.getResultList();
    }

        /**
         * Método que encuentra una facultad por su Id
         *
         * @param id
         * @return facultad encontrada
         */
        public FacultadEntity find(Long id){
            FacultadEntity facultadEncontrada = entityManager.find(FacultadEntity.class, id);
            return facultadEncontrada;
        }
        
        /**
         * Este metodo nos permite crear una facultad
         * @param facultadCrear
         * @return facultadCrear
         */
        public FacultadEntity create(FacultadEntity facultadCrear){
            entityManager.persist(facultadCrear);
            return facultadCrear;
        }
        
        /**
         * Metodo que nos permite actualizar una facultad
         * @param facultadActualizar
         * @return
         */
        public FacultadEntity update(FacultadEntity facultadActualizar){
            entityManager.merge(facultadActualizar);
        return facultadActualizar;
        }
        
        /**
         * Metodo que nos permite eliminar una facultad
         * @param id
         */
        public void remove(Long id){
        FacultadEntity facultadEliminar = entityManager.find(FacultadEntity.class, id);
        entityManager.remove(facultadEliminar);
    }
}

