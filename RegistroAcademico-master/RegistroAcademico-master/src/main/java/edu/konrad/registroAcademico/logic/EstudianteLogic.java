/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.logic;

import edu.konrad.registroAcademico.entities.EstudianteEntity;
import edu.konrad.registroAcademico.persistence.EstudiantePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Lógica del negocio Estudiante
 *
 * @author Daniela CH
 */
@Stateless
public class EstudianteLogic {

    @Inject
    private EstudiantePersistence estudiantePersistence;

    /**
     * Método con el cual se obtienen la lista de estudiantes
     *
     * @return estudiantes
     */
    public List<EstudianteEntity> getEstudiante() {
        List<EstudianteEntity> estudiantes = estudiantePersistence.findAll();
        return estudiantes;
    }

    /**
     * Método con el cual se obtiene el estudiante por su Id
     *
     * @param id
     * @return estudiante hallado
     */
    public EstudianteEntity getEstudiante(Long id) {
        EstudianteEntity estudiante = estudiantePersistence.find(id);
        if (estudiante == null) {
            throw new IllegalArgumentException("El estudiante que busca no existe");
        }
        return estudiante;
    }

    /**
     * Método con el cual se crea un nuevo estudiante
     *
     * @param estudianteEntity
     * @return estudianteEntity
     */
    public EstudianteEntity createEstudiante(EstudianteEntity estudianteEntity) {
        estudiantePersistence.create(estudianteEntity);
        return estudianteEntity;
    }

    /**
     * Método con el cual se actualiza un estudiante
     *
     * @param id
     * @param estudianteEntity
     * @return estudiante
     */
    public EstudianteEntity updateEstudiante(Long id, EstudianteEntity estudianteEntity) {
        EstudianteEntity estudiante = estudiantePersistence.update(estudianteEntity);
        return estudiante;
    }

    /**
     * Método con el cual se elimina un estudiante por su id
     *
     * @param id
     */
    public void removeEstudiante(Long id) {
        estudiantePersistence.remove(id);
    }
}
