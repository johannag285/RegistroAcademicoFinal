/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.dto;

import edu.konrad.registroAcademico.entities.CoordinadorEntity;
import edu.konrad.registroAcademico.entities.FacultadEntity;
import edu.konrad.registroAcademico.entities.ProgramaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Lógica que permite la transformación de entity a DTO y de DTO a entity
 *
 * @author Daniela CH
 */
public class ProgramaDTO {

    /**
     * Atributo que hace referencia al id del objeto Programa
     */
    private Long id;

    /**
     * Atributo que hace referencia al nombre del objeto Programa
     */
    private String nombre;

    /**
     * Atributo que hace referencia al tipo de programa del objeto Programa
     */
    private String tipo_programa;

    /**
     * Atributo que hace referencia al id de la facultad del objeto Programa
     */
    private FacultadEntity facultad_id;

    /**
     * Atributo que hace referencia al nivel academico del objeto Programa
     */
    private String nivel_academico;

    /**
     * Atributo que hace referencia al id del coordinador del objeto Programa
     */
    private CoordinadorEntity coordinador_id;

    /**
     * Constructor por defecto
     */
    public ProgramaDTO() {
    }

    /**
     * Mapeo de tabla a objeto
     *
     * @param programaEntity
     */
    public ProgramaDTO(ProgramaEntity programaEntity) {
        this.id = programaEntity.getId_programa();
        this.nombre = programaEntity.getNom_programa();
        this.tipo_programa = programaEntity.getTipo_programa();
        this.facultad_id = programaEntity.getFACULTAD_id_fk();
        this.nivel_academico = programaEntity.getNivel_academico();
        this.coordinador_id = programaEntity.getCOORDINADOR_id_fk();
    }

    /**
     * Mapeo de objeto a tabla
     *
     * @return entity
     */
    public ProgramaEntity toEntity() {
        ProgramaEntity entity = new ProgramaEntity();
        entity.setId_programa(this.id);
        entity.setNom_programa(this.nombre);
        entity.setTipo_programa(this.tipo_programa);
        entity.setFACULTAD_id_fk(this.facultad_id);
        entity.setNivel_academico(this.nivel_academico);
        entity.setCOORDINADOR_id_fk(this.coordinador_id);
        return entity;
    }

    /**
     * Conversor lista entidad programa a lista de objetos programa
     *
     * @param programaEntitys
     * @return listaObjetoPrograma
     */
    public static List<ProgramaDTO>toListPrograma(List<ProgramaEntity> programaEntitys) {
        List<ProgramaDTO> listaObjetoPrograma = new ArrayList<>();
        for (int i = 0; i < programaEntitys.size(); i++) {
            listaObjetoPrograma.add(new ProgramaDTO(programaEntitys.get(i)));
        }
        return listaObjetoPrograma;
    }
    //Metodos Get y Set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_programa() {
        return tipo_programa;
    }

    public void setTipo_programa(String tipo_programa) {
        this.tipo_programa = tipo_programa;
    }

    public FacultadEntity getFacultad_id() {
        return facultad_id;
    }

    public void setFacultad_id(FacultadEntity facultad_id) {
        this.facultad_id = facultad_id;
    }

    public String getNivel_academico() {
        return nivel_academico;
    }

    public void setNivel_academico(String nivel_academico) {
        this.nivel_academico = nivel_academico;
    }

    public CoordinadorEntity getCoordinador_id() {
        return coordinador_id;
    }

    public void setCoordinador_id(CoordinadorEntity coordinador_id) {
        this.coordinador_id = coordinador_id;
    }
    

}
