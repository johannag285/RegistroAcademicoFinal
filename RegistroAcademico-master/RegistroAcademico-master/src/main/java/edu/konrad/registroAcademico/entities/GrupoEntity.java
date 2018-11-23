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
 * Clase encargada de modelar la tabla grupo
 *
 * @author Daniela CH
 */
@Entity(name = "Grupo")
public class GrupoEntity implements Serializable {

    /**
     * Llave primaria de la tabla grupo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_grupo;
     /**
     * Llave foranea de la tabla curso
     */
    @ManyToOne
    @JoinColumn(name = "curso_id_fk")
    private CursoEntity CURSO_id_fk;
     /**
     * Llave foranea de la tabla profesor
     */
    @ManyToOne
    @JoinColumn(name = "profesor_id_fk")
    private ProfesorEntity PROFESOR_id_fk;

    /**
     * Atributo que hace referencia a la columna de la cantidad de inscritos
     */
    @Column
    private long cantidad_inscritos;

    /**
     * Constructor de Grupo entity
     */
    public GrupoEntity() {
    }

    /*Metodos get y set*/
    public long getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(Long id_grupo) {
        this.id_grupo = id_grupo;
    }

    public CursoEntity getCURSO_id_fk() {
        return CURSO_id_fk;
    }

    public void setCURSO_id_fk(CursoEntity CURSO_id_fk) {
        this.CURSO_id_fk = CURSO_id_fk;
    }

    public ProfesorEntity getPROFESOR_id_fk() {
        return PROFESOR_id_fk;
    }

    public void setPROFESOR_id_fk(ProfesorEntity PROFESOR_id_fk) {
        this.PROFESOR_id_fk = PROFESOR_id_fk;
    }

    public long getCantidad_inscritos() {
        return cantidad_inscritos;
    }

    public void setCantidad_inscritos(Long cantidad_inscritos) {
        this.cantidad_inscritos = cantidad_inscritos;
    }

}
