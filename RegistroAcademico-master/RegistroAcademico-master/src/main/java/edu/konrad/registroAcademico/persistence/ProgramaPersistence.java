/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import edu.konrad.registroAcademico.entities.ProgramaEntity;

/**
 * Clase usada para manejar la transaccionalidad de la entidad Programa
 *
 * @author Daniela CH
 */
@Stateless
public class ProgramaPersistence {

    @PersistenceContext(unitName = "registroAcademicoPU")
    private EntityManager entityManager;

    /**
     * Metodo que lista todos los elementos que se encuentran en la tabla
     * programa
     *
     * @return lista de programas
     */
    public List<ProgramaEntity> findAll() {
        Query todos = entityManager.createQuery("select p from Programa p");
        return todos.getResultList();
    }

    /**
     * Metodo que encuentra un programa por su id
     *
     * @param id
     * @return programaEncontrado
     */
    public ProgramaEntity find(Long id) {
        ProgramaEntity programaEncontrado = entityManager.find(ProgramaEntity.class, id);
        return programaEncontrado;
    }

    /**
     * Metodo que permite crear un Programa
     *
     * @param programaCrear
     * @return programaCrear
     */
    
    public ProgramaEntity create(ProgramaEntity programaCrear) {
        entityManager.persist(programaCrear);
        return programaCrear;
    }

    /**
     * Metodo que permite actualizar un Programa
     *
     * @param programaActualizar
     * @return programaActualizar
     */
    public ProgramaEntity update(ProgramaEntity programaActualizar) {
        entityManager.merge(programaActualizar);
        return programaActualizar;
    }

    /**
     * Metodo que permite eliminar un Programa
     *
     * @param id
     */
    public void remove(Long id) {
        ProgramaEntity programaEliminar = entityManager.find(ProgramaEntity.class, id);
        entityManager.remove(programaEliminar);
    }
}
