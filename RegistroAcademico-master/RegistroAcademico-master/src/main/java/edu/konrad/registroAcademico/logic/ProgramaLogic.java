/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.logic;

import edu.konrad.registroAcademico.entities.ProgramaEntity;
import edu.konrad.registroAcademico.persistence.ProgramaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Lógica del negocio Programa
 *
 * @author Daniela CH
 */
@Stateless
public class ProgramaLogic {

    @Inject
    private ProgramaPersistence programaPersistence;

    /**
     * Método con el cual se obtienen la lista de programas
     *
     * @return programas
     */
    public List<ProgramaEntity> getPrograma() {
        List<ProgramaEntity> programas = programaPersistence.findAll();
        return programas;
    }

    /**
     * Método con el cual se obtiene el programa por su Id
     *
     * @param id
     * @return programa hallado
     */
    public ProgramaEntity getPrograma(Long id) {
        ProgramaEntity programa = programaPersistence.find(id);
        if (programa == null) {
            throw new IllegalArgumentException("El programa que busca no existe");
        }
        return programa;
    }
    
    /**
     * Método con el cual se crea un nuevo programa
     *
     * @param programaEntity
     * @return programaEntity
     */
    public ProgramaEntity createPrograma(ProgramaEntity programaEntity) {
        programaPersistence.create(programaEntity);
        return programaEntity;
    }

    /**
     * Método con el cual se actualiza un programa
     *
     * @param id
     * @param programaEntity
     * @return programa
     */
    public ProgramaEntity updatePrograma(Long id, ProgramaEntity programaEntity) {
        ProgramaEntity programa = programaPersistence.update(programaEntity);
        return programa;
    }

    /**
     * Método con el cual se elimina un programa por su id
     *
     * @param id
     */
    public void removePrograma(Long id) {
        programaPersistence.remove(id);
    }
}
