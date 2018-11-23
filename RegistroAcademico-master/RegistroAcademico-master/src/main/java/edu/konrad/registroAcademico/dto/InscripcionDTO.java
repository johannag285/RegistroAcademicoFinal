/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.dto;

import edu.konrad.registroAcademico.entities.EstudianteEntity;
import edu.konrad.registroAcademico.entities.HorarioEntity;
import edu.konrad.registroAcademico.entities.InscripcionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Lógica de transformación de entity a DTO y de DTO a entity
 * @author johanna
 */
public class InscripcionDTO {
    
    /**
     * Atributo que hace referencia al id del objeto Inscrpcion
     */
    private Long id;
    /**
     * Atributo que hace referencia al semestre del objeto Inscripcion
     */
    private Long semestre;
    /**
     * Atributo que hace referencia a la llavea foranea del objeto Estudiante
     */
    private EstudianteEntity ESTUDIANTE_id;
     /**
     * Atributo que hace referencia a la llavea foranea del objeto Horario
     */
    private HorarioEntity HORARIO_id;

    /**
     * Constructor por defecto
     */
    public InscripcionDTO() {
    }
    
    /**
     * mapeo de entidad a obejto
     * @param inscripcionEntity 
     */
    public InscripcionDTO(InscripcionEntity inscripcionEntity){
        this.id = inscripcionEntity.getId_inscripcion();
        this.semestre = inscripcionEntity.getSemestre();
        this.ESTUDIANTE_id = inscripcionEntity.getESTUDIANTE_id_fk();
        this.HORARIO_id = inscripcionEntity.getHORARIO_id_fk();
    }
    /**
     * Mapeo de objeto a tabla
     * @return entity
     */
    public InscripcionEntity toEntity(){
        InscripcionEntity entity = new InscripcionEntity();
        entity.setId_inscripcion(this.id);
        entity.setSemestre(this.semestre);
        entity.setESTUDIANTE_id_fk(this.ESTUDIANTE_id);
        entity.setHORARIO_id_fk(this.HORARIO_id);
        return entity;
    }
    
    /**
     * Conversor lista entidad inscripcion a lista de objetos inscrpcion
     * @param inscripcionEntitys
     * @return listaObjetoInscripcion
     */
    public static List<InscripcionDTO> toListInscripcion(List<InscripcionEntity> inscripcionEntitys){
        List<InscripcionDTO> listaObjetoInscripcion = new ArrayList<>();
        for(int i = 0; i < listaObjetoInscripcion.size(); i++){
            listaObjetoInscripcion.add(new InscripcionDTO(inscripcionEntitys.get(i)));
        }
        return listaObjetoInscripcion;
    }

    /**
     * métodos get ys et
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSemestre() {
        return semestre;
    }

    public void setSemestre(Long semestre) {
        this.semestre = semestre;
    }

    public EstudianteEntity getESTUDIANTE_id() {
        return ESTUDIANTE_id;
    }

    public void setESTUDIANTE_id(EstudianteEntity ESTUDIANTE_id) {
        this.ESTUDIANTE_id = ESTUDIANTE_id;
    }

    public HorarioEntity getHORARIO_id() {
        return HORARIO_id;
    }

    public void setHORARIO_id(HorarioEntity HORARIO_id) {
        this.HORARIO_id = HORARIO_id;
    }
    
    
}
