/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.persistence;

import edu.konrad.registroAcademico.entities.EstudianteEntity;
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
public class EstudiantePersistence {
    @PersistenceContext(unitName = "registroAcademicoPU")
    private EntityManager entityManager;

    /**
     * Metodo que lista todos los elementos que se encuentran en la tabla estudiante
     *
     * @return lista de estudiante
     */
    public List<EstudianteEntity> findAll() {
        Query todos = entityManager.createQuery("select p from Estudiante p");
        return todos.getResultList();
    }

    /**
     * Metodo que encuentra un estudiante por su id
     *
     * @param id
     * @return estudianteEncontrado
     */
    public EstudianteEntity find(Long id) {
        EstudianteEntity estudianteEncontrado = entityManager.find(EstudianteEntity.class, id);
        return estudianteEncontrado;
    }

    /**
     * Metodo que permite crear un estudiante
     *
     * @param estudianteCrear
     * @return estudianteCrear
     */
    public EstudianteEntity create(EstudianteEntity estudianteCrear) {
        entityManager.persist(estudianteCrear);
        return estudianteCrear;
    }

    /**
     * Metodo que permite actualizar un estudiante
     *
     * @param estudianteActualizar
     * @return estudianteActualizar
     */
    public EstudianteEntity update(EstudianteEntity estudianteActualizar) {
        entityManager.merge(estudianteActualizar);
        return estudianteActualizar;
    }

    /**
     * Metodo que permite eliminar un estudiante
     *
     * @param id
     */
    public void remove(Long id) {
        EstudianteEntity estudianteEliminar = entityManager.find(EstudianteEntity.class, id);
        entityManager.remove(estudianteEliminar);
    }

}
