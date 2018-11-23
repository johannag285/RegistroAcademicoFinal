/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.persistence;

import edu.konrad.registroAcademico.entities.GrupoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase es usada para manejar la transaccionalidad de la entidad estudiante
 *
 * @author Daniela CH
 */
@Stateless
public class GrupoPersistence {

    @PersistenceContext(unitName = "registroAcademicoPU")
    private EntityManager entityManager;

    /**
     * Metodo que lista todos los elementos que se encuentran en la tabla grupo
     *
     * @return lista de grupos
     */
    public List<GrupoEntity> findAll() {
        Query todos = entityManager.createQuery("select p from Grupo p");
        return todos.getResultList();
    }

    /**
     * Metodo que encuentra un grupo por su id
     *
     * @param id
     * @return grupoEncontrado
     */
    public GrupoEntity find(Long id) {
        GrupoEntity grupoEncontrado = entityManager.find(GrupoEntity.class, id);
        return grupoEncontrado;
    }

    /**
     * Metodo que permite crear un grupo
     *
     * @param grupoCrear
     * @return grupoCrear
     */
    public GrupoEntity create(GrupoEntity grupoCrear) {
        entityManager.persist(grupoCrear);
        return grupoCrear;
    }

    /**
     * Metodo que permite actualizar un grupo
     *
     * @param grupoActualizar
     * @return grupoActualizar
     */
    public GrupoEntity update(GrupoEntity grupoActualizar) {
        entityManager.merge(grupoActualizar);
        return grupoActualizar;
    }

    /**
     * Metodo que permite eliminar un grupo
     *
     * @param id
     */
    public void remove(Long id) {
        GrupoEntity grupoEliminar = entityManager.find(GrupoEntity.class, id);
        entityManager.remove(grupoEliminar);
    }

}
