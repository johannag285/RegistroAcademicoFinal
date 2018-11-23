/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.logic;

import edu.konrad.registroAcademico.entities.GrupoEntity;
import edu.konrad.registroAcademico.persistence.GrupoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Lógica del negocio Grupo
 *
 * @author Daniela CH
 */
@Stateless
public class GrupoLogic {
    @Inject
    private GrupoPersistence grupoPersistence;

    /**
     * Método con el cual se obtienen la lista de grupos
     *
     * @return grupos
     */
    public List<GrupoEntity> getGrupo() {
        List<GrupoEntity> grupos = grupoPersistence.findAll();
        return grupos;
    }
    /**
     * Método con el cual se obtiene el grupo por su Id
     *
     * @param id
     * @return grupo hallado
     */
    public GrupoEntity getGrupo(Long id) {
        GrupoEntity grupo = grupoPersistence.find(id);
        if (grupo == null) {
            throw new IllegalArgumentException("El grupo que busca no existe");
        }
        return grupo;
    }
    
    /**
     * Método con el cual se crea un nuevo grupo
     *
     * @param grupoEntity
     * @return grupoEntity
     */
    public GrupoEntity createGrupo(GrupoEntity grupoEntity) {
        grupoPersistence.create(grupoEntity);
        return grupoEntity;
    }
    /**
     * Método con el cual se actualiza un grupo
     *
     * @param id
     * @param grupoEntity
     * @return grupo
     */
    public GrupoEntity updateGrupo(Long id, GrupoEntity grupoEntity) {
        GrupoEntity grupo = grupoPersistence.update(grupoEntity);
        return grupo;
    }

    /**
     * Método con el cual se elimina un grupo por su id
     *
     * @param id
     */
    public void removeGrupo(Long id) {
        grupoPersistence.remove(id);
    }
}
