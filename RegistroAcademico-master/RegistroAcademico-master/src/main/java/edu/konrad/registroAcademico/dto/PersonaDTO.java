/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.dto;

import edu.konrad.registroAcademico.entities.PersonaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Lógica de transformación de entity a DTO y de DTO a entity
 * @author johanna
 */
public class PersonaDTO {
    /**
     * Atributo que hace referencia al id del objeto Persona
     */
    private Long id;
    /**
     * Atributo que hace referencia al nombre del objeto Persona
     */
    private String nombre;
    
    /**
     * Atributo que hace referencia al apellido del objeto Persona
     */
    private String apellido;
    /**
     * Atributo que hace referencia al tipo de documento del objeto Persona
     */
    private String tipo_documento;
    /**
     * Atributo que hace referencia al número del documento del objeto Persona
     */
    private String num_documento;
    /**
     * Atributo que hace referencia al genero del objeto Persona
     */
    private String genero;
    /**
     * Atributo que hace referencia al email del objeto Persona 
     */
    private String email;
    
     /**
     * Constructor por defecto
     */

    public PersonaDTO() {
    }
      
     /**
      * mapeo de tabla a oobjeto
      * @param personaEntity 
      */
    
    public PersonaDTO(PersonaEntity personaEntity){
        this.id = personaEntity.getId_persona();
        this.nombre = personaEntity.getNom_persona();
        this.apellido = personaEntity.getApelllido_persona();
        this.tipo_documento = personaEntity.getTipo_documento();
        this.num_documento = personaEntity.getNum_documento();
        this.genero = personaEntity.getGenero();
        this.email = personaEntity.getEmail();
    }
    
     /**
      * Mapeo de objeto a tabla
      * @return entity
      */
    
    public PersonaEntity toEntity(){
       PersonaEntity entity = new  PersonaEntity();
       entity.setId_persona(this.id);
       entity.setNom_persona(this.nombre);
       entity.setApelllido_persona(this.apellido);
       entity.setTipo_documento(this.tipo_documento);
       entity.setNum_documento(this.num_documento);
       entity.setGenero(this.genero);
       entity.setEmail(this.email);
       return entity;
    }
    /**
     * Conversor lista entidad persona a lista de objetos persona
     * @param personaEntitys
     * @return listaObjetoPersona
     */
     
    public static List<PersonaDTO> toListPersona(List<PersonaEntity> personaEntitys){
        List<PersonaDTO> listaObjetoPersona = new ArrayList<>();
        for(int i=0; i<personaEntitys.size();i++ ){
            listaObjetoPersona.add(new PersonaDTO (personaEntitys.get(i)));
        }
        return listaObjetoPersona;
    }  

    /**
     * Métodos get y set
     */
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
