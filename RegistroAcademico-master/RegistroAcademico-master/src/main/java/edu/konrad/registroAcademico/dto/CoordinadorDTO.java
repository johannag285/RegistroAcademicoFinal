/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.dto;

import edu.konrad.registroAcademico.entities.CoordinadorEntity;
import edu.konrad.registroAcademico.entities.PersonaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Lógica de transformación de entity a DTO y de DTO a entity
 * @author johanna
 */
public class CoordinadorDTO {
    
    /**
     * Atributo que hace referencia al id del objeto Coordinador
     */
    private Long id;
    /**
     * Atributo que hace referencia al código del objeto Coordinador
     */
    private String codigo;
    /**
     * Atributo que hace referencia a la llave foranea del objeto Persona
     */
    private PersonaEntity PERSONA_id;
    

    /**
     * Constructor por defecto
     */
    public CoordinadorDTO() {
    }
    
    /**
     * mapero de tabla a objeto
     * @param coordinadorEntity 
     */
    public CoordinadorDTO(CoordinadorEntity coordinadorEntity){
        this.id = coordinadorEntity.getId_coordinador();
        this.codigo = coordinadorEntity.getCod_coordinador();
        this.PERSONA_id = coordinadorEntity.getPERSONA_id_fk();
    }
    /**
     * Mapeo de objeto a tabla
     * @return entity
     */
    public CoordinadorEntity toEntity(){
        CoordinadorEntity entity = new CoordinadorEntity();
        entity.setId_coordinador(this.id);
        entity.setCod_coordinador(this.codigo);
        entity.setPERSONA_id_fk(this.PERSONA_id);
        return entity;
    }
    
    /**
     * Conversor lista entidad coordiandor a lista de objetos coordindor
     * @param coordinadorEntitys
     * @return listaObjetoCoordinador
     */
    public static List<CoordinadorDTO> toListCoordinador(List<CoordinadorEntity> coordinadorEntitys){
        List<CoordinadorDTO> listaObjetoCoordinador = new ArrayList<>();
        for(int i = 0; i< listaObjetoCoordinador.size(); i++){
            listaObjetoCoordinador.add(new CoordinadorDTO (coordinadorEntitys.get(i)));
        }
        return listaObjetoCoordinador;
    }

    /**
     * métodos get y set
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public PersonaEntity getPERSONA_id() {
        return PERSONA_id;
    }

    public void setPERSONA_id(PersonaEntity PERSONA_id) {
        this.PERSONA_id = PERSONA_id;
    }
    
    
}
