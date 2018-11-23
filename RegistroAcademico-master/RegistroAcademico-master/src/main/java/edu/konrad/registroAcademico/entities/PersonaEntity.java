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
 * Clase encargada de modelar la tabla Persona
 * @author Johanna G.
 */
@Entity (name="Persona")

public class PersonaEntity implements Serializable{
    /**
     * Llave primaria de la tabla Persona
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_persona;
    
    /**
     * Atributo que hace referencia a la columna del nombre de la persona
     */
    
    @Column
    private String nom_persona;
    
    /**
     * Atributo que hace referencia a la columna del apellido de la persona
     */
    
    @Column
    private String apelllido_persona;
    
    /**
     * Atributo que hace referencia a la columna de tipo de documento de la persona
     */
    @Column
    private String tipo_documento;
    
    /**
     * Atributo que hace referencia a la columna del número del documento de la persona
     */
    @Column
    private String num_documento;
    
    /**
     * Atributo que hace referencia a la columna del genero de la persona
     */
    @Column
    private String genero;
    
    /**
     * Atributo que hace referncia a la columna del email de la persona
     */
    
    @Column
    private String email;

    
    /**
     * Constructor de la entitdad del producto
     */
    
    public PersonaEntity(){
        
    }

     /**
     * Métodos set y get
     */
    
    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public String getNom_persona() {
        return nom_persona;
    }

    public void setNom_persona(String nom_persona) {
        this.nom_persona = nom_persona;
    }

    public String getApelllido_persona() {
        return apelllido_persona;
    }

    public void setApelllido_persona(String apelllido_persona) {
        this.apelllido_persona = apelllido_persona;
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
