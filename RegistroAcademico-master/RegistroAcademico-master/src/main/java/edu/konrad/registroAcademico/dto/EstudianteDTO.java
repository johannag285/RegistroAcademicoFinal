/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.dto;

import edu.konrad.registroAcademico.entities.EstudianteEntity;
import edu.konrad.registroAcademico.entities.PersonaEntity;
import edu.konrad.registroAcademico.entities.ProgramaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Lógica que permite la transformación de entity a DTO y de DTO a entity
 *
 * @author Daniela CH
 */
public class EstudianteDTO {

    /**
     * Atributo que hace referencia al id del objeto Estudiante
     */
    private Long id;

    /**
     * Atributo que hace referencia al codigo del objeto Estudiante
     */
    private String codigo_estudiante;

    /**
     * Atributo que hace referencia al id de la persona del objeto Estudiante
     */
    private PersonaEntity persona_id;

    /**
     * Atributo que hace referencia al id del programa del objeto Estudiante
     */
    private ProgramaEntity programa_id;

    /**
     * Constructor por defecto
     */
    public EstudianteDTO() {
    }

    /**
     * Mapeo de tabla a objeto
     *
     * @param estudianteEntity
     */
    public EstudianteDTO(EstudianteEntity estudianteEntity) {
        this.id = estudianteEntity.getId_estudiante();
        this.codigo_estudiante = estudianteEntity.getCod_estudiante();
        this.persona_id = estudianteEntity.getPERSONA_id_fk();
        this.programa_id = estudianteEntity.getPROGRAMA_id_fk();
    }

    /**
     * Mapeo de objeto a tabla
     *
     * @return entity
     */
    public EstudianteEntity toEntity() {
        EstudianteEntity entity = new EstudianteEntity();
        entity.setId_estudiante(this.id);
        entity.setCod_estudiante(this.codigo_estudiante);
        entity.setPERSONA_id_fk(this.persona_id);
        entity.setPROGRAMA_id_fk(this.programa_id);
        return entity;
    }

    /**
     * Conversor lista entidad estudiante a lista de objetos estudiante
     *
     * @param estudianteEntitys
     * @return listaObjetoEstudiante
     */
    public static List<EstudianteDTO> toListEstudiante(List<EstudianteEntity> estudianteEntitys) {
        List<EstudianteDTO> listaObjetoEstudiante = new ArrayList<>();
        for (int i = 0; i < estudianteEntitys.size(); i++) {
            listaObjetoEstudiante.add(new EstudianteDTO(estudianteEntitys.get(i)));
        }
        return listaObjetoEstudiante;
    }
    //Metodos Get y Set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo_estudiante() {
        return codigo_estudiante;
    }

    public void setCodigo_estudiante(String codigo_estudiante) {
        this.codigo_estudiante = codigo_estudiante;
    }

    public PersonaEntity getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(PersonaEntity persona_id) {
        this.persona_id = persona_id;
    }

    public ProgramaEntity getPrograma_id() {
        return programa_id;
    }

    public void setPrograma_id(ProgramaEntity programa_id) {
        this.programa_id = programa_id;
    }

}
