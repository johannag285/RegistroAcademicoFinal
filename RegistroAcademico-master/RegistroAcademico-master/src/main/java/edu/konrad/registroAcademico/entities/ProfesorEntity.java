/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 *
 * @author Carlos David
 */

@Entity (name = "Profesor")
public class ProfesorEntity implements Serializable{

    /**
     * Llave primaria de la tabla Profesor.
     */ 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_profesor;

    /**
     * Atributo de la tabla Profesor que hace referencia al codigo del profesor.
     */
    @Column
    private String cod_profesor;
    
    /**
     * Atributo de la tabla Profesor que hace referencia a la llave foranea que conecta con la tabla Persona.
     */
    @ManyToOne
    @JoinColumn(name = "PERSONA_id_fk")
    private PersonaEntity PERSONA_id_fk;
    
    /**
     * Atributo de la tabla Profesor que hace referencia a la llave foranea que conecta con la tabla Programa.
     */
    @ManyToOne
    @JoinColumn(name = "PROGRAMA_id_fk")
    private ProgramaEntity PROGRAMA_id_fk;
    
    /**
     * Atributo de la tabla Profesor que hace referencia al area de profundización del docente.
     */
    @Column
    private String area_profundizacion;

   
    
    /**
     * Constructor de la tabla ProfesorEntity.
     */
    public ProfesorEntity(){
        
    }
    
      /**
     * Metodos Getters y Setters de la tabla Profesor.
     */

    public Long getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Long id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getCod_profesor() {
        return cod_profesor;
    }

    public void setCod_profesor(String cod_profesor) {
        this.cod_profesor = cod_profesor;
    }

    public PersonaEntity getPERSONA_id_fk() {
        return PERSONA_id_fk;
    }

    public void setPERSONA_id_fk(PersonaEntity PERSONA_id_fk) {
        this.PERSONA_id_fk = PERSONA_id_fk;
    }

    public ProgramaEntity getPROGRAMA_id_fk() {
        return PROGRAMA_id_fk;
    }

    public void setPROGRAMA_id_fk(ProgramaEntity PROGRAMA_id_fk) {
        this.PROGRAMA_id_fk = PROGRAMA_id_fk;
    }

    public String getArea_profundizacion() {
        return area_profundizacion;
    }

    public void setArea_profundizacion(String area_profundizacion) {
        this.area_profundizacion = area_profundizacion;
    }
  
    
    
}
