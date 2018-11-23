/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.persistence;

import edu.konrad.registroAcademico.entities.CursoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Clase usada para manejar la transaccionalidad de la entidad Curso
 *
 * @author johanna
 */
@Stateless
public class CursoPersistence {

    @PersistenceContext(unitName = "registroAcademicoPU")
    private EntityManager entityManager;
    
    /**
   * Método que lista todos los elementos que se encuentra en la tabla curso 
   * @return lista de cursos
   */
    
    public List<CursoEntity> finAll(){
        Query todos = entityManager.createQuery("select p from Curso p" );
        return todos.getResultList();
    }
    
    /**
     * Método que encuentra a un curso por su Id
     * @param id
     * @return curso encontrado
     */
    
    public CursoEntity find(Long id){
        CursoEntity cursoEncontrado = entityManager.find(CursoEntity.class, id);
        return cursoEncontrado;
    }
    
    /**
     * Metodo que nos permite crear un Curso
     * @param cursoCrear
     * @return cursoCrear
     */
    
    public CursoEntity create(CursoEntity cursoCrear){
        entityManager.persist(cursoCrear);
        return cursoCrear;
    }
    
     /**
     * Metodo que nos permite actualizar un Curso
     * @param cursoActualizar
     * @return cursoActualizar 
     */
    
    public CursoEntity update(CursoEntity cursoActualizar){
        entityManager.merge(cursoActualizar);
        return cursoActualizar;
    }
    
    /**
     * Metodo que nos permite eleiminar un Curso
     * @param id 
     */
    
    public void remove (Long id){
        CursoEntity cursoEliminar = entityManager.find(CursoEntity.class, id);
        entityManager.remove(cursoEliminar);
    }
}
