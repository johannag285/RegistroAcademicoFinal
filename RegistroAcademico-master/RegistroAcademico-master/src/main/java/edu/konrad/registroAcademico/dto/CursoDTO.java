/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.dto;

import edu.konrad.registroAcademico.entities.CursoEntity;
import edu.konrad.registroAcademico.entities.ProgramaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Lógica de transformación de entity a DTO y de DTO a entity
 * @author johanna
 */
public class CursoDTO {
    
    /**
     * Atributo que hace referencia al id del objeto Curso
     */
    private Long id;
    
    /**
     * Atributo que hace referencia al nombre del objeto Curso
     */
    private String nombre;
    /**
     * Atributo que hace referencia a la llave foranea del objeto Programa
     */
    private ProgramaEntity PROGRAMA_id;

    /**
     * Constructor por defecto
     */
    public CursoDTO() {
    }
    
    /**
     * Mapeo de tabla a objeto
     * @param cursoEntity 
     */
    public CursoDTO (CursoEntity cursoEntity){
        this.id = cursoEntity.getId_curso();
        this.nombre = cursoEntity.getNom_curso();
        this.PROGRAMA_id = cursoEntity.getPROGRAMA_id_fk();
    }
    
    /**
     * Mapeo de objeto a tabla
     * @return entity
     */
    public CursoEntity toEntity(){
        CursoEntity entity = new CursoEntity();
        entity.setId_curso(this.id);
        entity.setNom_curso(this.nombre);
        entity.setPROGRAMA_id_fk(this.PROGRAMA_id);
        return entity;
    }
    
    /**
     * Conversor lista entidad curso a lista de objetos curso
     * @param cursoEntitys
     * @return listaObjetoCurso
     */
    public static List<CursoDTO> toListCurso(List<CursoEntity> cursoEntitys){
        List<CursoDTO> listaObjetoCurso = new ArrayList<>();
        for(int i = 0; i<cursoEntitys.size(); i++){
            listaObjetoCurso.add(new CursoDTO(cursoEntitys.get(i)));
        }
        return listaObjetoCurso;
    }

    /*métodos set y get */
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

    public ProgramaEntity getPROGRAMA_id() {
        return PROGRAMA_id;
    }

    public void setPROGRAMA_id(ProgramaEntity PROGRAMA_id) {
        this.PROGRAMA_id = PROGRAMA_id;
    }
    
    
}
