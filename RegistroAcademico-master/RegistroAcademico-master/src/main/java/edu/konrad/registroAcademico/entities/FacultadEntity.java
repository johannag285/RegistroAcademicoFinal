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

/**
 *
 * @author Carlos David
 */

@Entity (name ="Facultad")
public class FacultadEntity implements Serializable{
    
    /**
     * Llave primaria de la tabla Facultad.
     */ 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_facultad;
    
    /**
     * Atributo de la tabla Facultad que hace referencia al nombre de la facultad.
     */
    @Column
    private String nom_facultad;
    
    /**
     * Atributo de la tabla Facultad que hace referencia al nivel academico.
     */
    @Column
    private String nivel_academico;
    
    /**
     * Contructor de la tabla Facultad
     */
    public FacultadEntity(){
        
    }
    
    /**
     * Getters y Setters de la tabla de Facultad.
     */
    public Long getId_facultad() {
        return id_facultad;
    }

    public String getNom_facultad() {
        return nom_facultad;
    }

    public String getNivel_academico() {
        return nivel_academico;
    }

    public void setId_facultad(Long id_facultad) {
        this.id_facultad = id_facultad;
    }

    public void setNom_facultad(String nom_facultad) {
        this.nom_facultad = nom_facultad;
    }

    public void setNivel_academico(String nivel_academico) {
        this.nivel_academico = nivel_academico;
    }
    
}
