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
import javax.persistence.OneToMany;

/**
 *
 * @author Carlos David
 */
@Entity (name = "Horario")
public class HorarioEntity implements Serializable{
    
    /**
     * Llave primaria de la tabla Horario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_horario;
    
    /**
     * Atributo de la tabla Horario que hace referencia al dia del horario.
     */
    @Column
    private String dia_horario;
    
    /**
     * Atributo de la tabla Horario que hace referencia a la hora que inicia una clase.
     */
    @Column
    private long inicio_clase;
    
    /**
     * Atributo de la tabla Horario que hace referencia a la hora que termina una clase
     */
    @Column
    private long fin_clase;
    
    /**
     * Atributo de la tabla Horario que hace referencia a el salon donde se dictará la clase.
     */
    @Column
    private String salon_clase;
    
    /**
     * Atributo de la tabla Horario que hace referencia a la llave foranea que conecta con la tabla Grupo.
     */
    @ManyToOne
    @JoinColumn(name="GRUPO_id_fk")
    private GrupoEntity GRUPO_id_fk;

    
    /**
     * Constructor de la tabla HorarioEntity.
     */
    public HorarioEntity() {
    }
    
    
    
     /**
     * Metodos Getters y Setters de la tabla HorarioEntity.
     */

    public Long getId_horario() {
        return id_horario;
    }

    public void setId_horario(Long id_horario) {
        this.id_horario = id_horario;
    }

    public String getDia_horario() {
        return dia_horario;
    }

    public void setDia_horario(String dia_horario) {
        this.dia_horario = dia_horario;
    }

    public long getInicio_clase() {
        return inicio_clase;
    }

    public void setInicio_clase(long inicio_clase) {
        this.inicio_clase = inicio_clase;
    }

    public long getFin_clase() {
        return fin_clase;
    }

    public void setFin_clase(long fin_clase) {
        this.fin_clase = fin_clase;
    }

    public String getSalon_clase() {
        return salon_clase;
    }

    public void setSalon_clase(String salon_clase) {
        this.salon_clase = salon_clase;
    }

    public GrupoEntity getGRUPO_id_fk() {
        return GRUPO_id_fk;
    }

    public void setGRUPO_id_fk(GrupoEntity GRUPO_id_fk) {
        this.GRUPO_id_fk = GRUPO_id_fk;
    }
    
    
}
