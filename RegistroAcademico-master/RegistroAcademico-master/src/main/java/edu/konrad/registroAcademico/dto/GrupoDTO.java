/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.dto;

import edu.konrad.registroAcademico.entities.CursoEntity;
import edu.konrad.registroAcademico.entities.GrupoEntity;
import edu.konrad.registroAcademico.entities.ProfesorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Lógica que permite la transformación de entity a DTO y de DTO a entity
 *
 * @author Daniela CH
 */
public class GrupoDTO {

    /**
     * Atributo que hace referencia al id del objeto Grupo
     */
    private Long id;

    /**
     * Atributo que hace referencia al id del curso del objeto Grupo
     */
    private CursoEntity curso_id;

    /**
     * Atributo que hace referencia a la cantidad de inscritos del objeto Grupo
     */
    private Long cantidad_inscritos;

    /**
     * Atributo que hace referencia al id del profesor del objeto Grupo
     */
    private ProfesorEntity profesor_id;

    /**
     * Constructor por defecto
     */
    public GrupoDTO() {
    }

    /**
     * Mapeo de tabla a objeto
     *
     * @param grupoEntity
     */
    public GrupoDTO(GrupoEntity grupoEntity) {
        this.id = grupoEntity.getId_grupo();
        this.curso_id = grupoEntity.getCURSO_id_fk();
        this.cantidad_inscritos = grupoEntity.getCantidad_inscritos();
        this.profesor_id = grupoEntity.getPROFESOR_id_fk();
    }

    /**
     * Mapeo de objeto a tabla
     *
     * @return entity
     */
    public GrupoEntity toEntity() {
        GrupoEntity entity = new GrupoEntity();
        entity.setId_grupo(this.id);
        entity.setCURSO_id_fk(this.curso_id);
        entity.setCantidad_inscritos(this.cantidad_inscritos);
        entity.setPROFESOR_id_fk(this.profesor_id);
        return entity;
    }

    /**
     * Conversor lista entidad grupo a lista de objetos grupo
     *
     * @param grupoEntitys
     * @return listaObjetoGrupo
     */
    public static List<GrupoDTO> toListGrupo(List<GrupoEntity> grupoEntitys) {
        List<GrupoDTO> listaObjetoGrupo = new ArrayList<>();
        for (int i = 0; i < grupoEntitys.size(); i++) {
            listaObjetoGrupo.add(new GrupoDTO(grupoEntitys.get(i)));
        }
        return listaObjetoGrupo;
    }
    //Metodos Get y Set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CursoEntity getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(CursoEntity curso_id) {
        this.curso_id = curso_id;
    }

    public Long getCantidad_inscritos() {
        return cantidad_inscritos;
    }

    public void setCantidad_inscritos(Long cantidad_inscritos) {
        this.cantidad_inscritos = cantidad_inscritos;
    }

    public ProfesorEntity getProfesor_id() {
        return profesor_id;
    }

    public void setProfesor_id(ProfesorEntity profesor_id) {
        this.profesor_id = profesor_id;
    }
}
