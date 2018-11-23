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
 *Clase encargada de modelar la tabla curso
 * @author johannna
 */
@Entity (name = "Curso")
public class CursoEntity implements Serializable {
 /**
  * Llave primaria de la tabla persona
  */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_curso;
    
    /**
     * Atributo que hace referencia al nombre del curso
     */
    @Column
    private String nom_curso;
    
    /**
     * Atributo que hace referncia a llave foranea del programa
     */
    @ManyToOne
    @JoinColumn(name = "PROGRAMA_id_fk")
    private ProgramaEntity PROGRAMA_id_fk;
    

    /**
     * Contructor de entidad de curso
     */
    public CursoEntity() {
    }
    
    /**
     * Métodos set y get
     */
    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public String getNom_curso() {
        return nom_curso;
    }

    public void setNom_curso(String nom_curso) {
        this.nom_curso = nom_curso;
    }

    public ProgramaEntity getPROGRAMA_id_fk() {
        return PROGRAMA_id_fk;
    }

    public void setPROGRAMA_id_fk(ProgramaEntity PROGRAMA_id_fk) {
        this.PROGRAMA_id_fk = PROGRAMA_id_fk;
    }
        
}
