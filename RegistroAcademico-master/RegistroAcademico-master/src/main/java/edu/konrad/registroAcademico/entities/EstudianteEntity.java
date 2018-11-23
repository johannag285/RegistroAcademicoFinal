
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
 * Clase encargada de modelar la tabla estudiante
 *
 * @author Daniela CH
 */
@Entity(name = "Estudiante")
public class EstudianteEntity implements Serializable {

    /**
     * Llave primaria de la tabla estudiante
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_estudiante;

    /**
     * Llave foranea de la tabla persona
     */
    @ManyToOne
    @JoinColumn(name = "persona_id_fk")
    private PersonaEntity PERSONA_id_fk;
    /**
     * Llave foranea de la tabla programa
     */
    @ManyToOne
    @JoinColumn(name = "programa_id_fk")
    private ProgramaEntity PROGRAMA_id_fk;

    /**
     * Atributo que hace referencia a la columna del código del estudiante
     */
    @Column
    private String cod_estudiante;

    /**
     * Constructor de Estudiante entity
     */
    public EstudianteEntity() {
    }

    /*Metodos get y set */
    public Long getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(Long id_estudiante) {
        this.id_estudiante = id_estudiante;
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
    public String getCod_estudiante() {
        return cod_estudiante;
    }

    public void setCod_estudiante(String cod_estudiante) {
        this.cod_estudiante = cod_estudiante;
    }

}
