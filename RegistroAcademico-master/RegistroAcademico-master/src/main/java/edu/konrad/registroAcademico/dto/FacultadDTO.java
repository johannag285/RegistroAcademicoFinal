/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.dto;

import edu.konrad.registroAcademico.entities.FacultadEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos David
 */
public class FacultadDTO {
    
    /**
     * Atributo que hace referencia al id del objeto Facultad
     */
    private Long id;
    
    /**
     * Atributo que hace referencia a la columna del nombre de la facultad.
     */
    private String nom_facultad;
    
    /**
     * Atributo que hace referencia a la columna del nivel academico de la facultad.
     */
    private String nivel_academico;
    
    /**
     * Constructor por defecto
     */
    public FacultadDTO() {
        
    }
    
    /**
      * mapeo de tabla a objeto
      * @param facultadEntity
      */
    public FacultadDTO(FacultadEntity facultadEntity){
        this.id = facultadEntity.getId_facultad();
        this.nom_facultad = facultadEntity.getNom_facultad();
        this.nivel_academico = facultadEntity.getNivel_academico();
    }
    
    /**
      * Mapeo de objeto a tabla
      * @return 
      */
    public FacultadEntity toEntity(){
       FacultadEntity entity = new  FacultadEntity();
       entity.setId_facultad(this.id);
       entity.setNom_facultad(this.nom_facultad);
       entity.setNivel_academico(this.nivel_academico);
       return entity;
    }
    
    /**
     * Conversor lista entidad facultad a lista de objetos facultad
     * @param facultadEntitys
     * @return listaObjetoFacultad
     */
    public static List<FacultadDTO> toListFacultad(List<FacultadEntity> facultadEntitys){
        List<FacultadDTO> listaObjetoFacultad = new ArrayList<>();
        for(int i=0; i<facultadEntitys.size();i++ ){
            listaObjetoFacultad.add(new FacultadDTO (facultadEntitys.get(i)));
        }
        return listaObjetoFacultad;
    }  

    /**
     * Métodos get y set
     */
    public Long getId() {
        return id;
    }

    public String getNom_facultad() {
        return nom_facultad;
    }

    public String getNivel_academico() {
        return nivel_academico;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom_facultad(String nom_facultad) {
        this.nom_facultad = nom_facultad;
    }

    public void setNivel_academico(String nivel_academico) {
        this.nivel_academico = nivel_academico;
    }
    
    
}
