/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.dto;

import edu.konrad.registroAcademico.entities.GrupoEntity;
import edu.konrad.registroAcademico.entities.HorarioEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos David
 */
public class HorarioDTO {
    
    /**
     * Atributo que hace referencia al id del objeto Horario
     */
    private Long id;
    
    /**
     * Atributo que hace referencia a la columna del dia de Horario
     */
    private String dia_horario;
    
    /**
     * Atributo que hace referencia a la columna del inicio de clase de Horario
     */
    private long inicio_clase;
    
    /**
     * Atributo que hace referencia a la columna delfin de clase de Horario
     */
    private long fin_clase;
    
    /**
     * Atributo que hace referencia a la columna del salon del Horario
     */
    private String salon_clase;
    
    /**
     * Atributo que hace referencia al id de grupo del horario
     */
    private GrupoEntity grupo_id;
    
    /**
      * mapeo de tabla a objeto
      * @param horarioEntity
      */
    public HorarioDTO(HorarioEntity horarioEntity){
        this.id = horarioEntity.getId_horario();
        this.dia_horario = horarioEntity.getDia_horario();
        this.inicio_clase = horarioEntity.getInicio_clase();
        this.fin_clase = horarioEntity.getFin_clase();
        this.salon_clase = horarioEntity.getSalon_clase();
    }
    
    /**
      * Mapeo de objeto a tabla
      * @return 
      */
    public HorarioEntity toEntity(){
       HorarioEntity entity = new  HorarioEntity();
       entity.setDia_horario(this.dia_horario);
       entity.setInicio_clase(this.inicio_clase);
       entity.setFin_clase(this.fin_clase);
       entity.setSalon_clase(this.salon_clase);
       return entity;
    }
    
    /**
     * Conversor lista entidad horario a lista de objetos horario
     * @param horarioEntitys
     * @return listaObjetoHorario
     */
    public static List<HorarioDTO> toListHorario(List<HorarioEntity> horarioEntitys){
        List<HorarioDTO> listaObjetoHorario = new ArrayList<>();
        for(int i=0; i<horarioEntitys.size();i++ ){
            listaObjetoHorario.add(new HorarioDTO (horarioEntitys.get(i)));
        }
        return listaObjetoHorario;
    }  

    /**
     * Constructor por defecto
     */
    public HorarioDTO() {
    }
    

    /**
     * Métodos get y set
     */
    public Long getId() {
        return id;
    }

    public String getDia_horario() {
        return dia_horario;
    }

    public long getInicio_clase() {
        return inicio_clase;
    }

    public long getFin_clase() {
        return fin_clase;
    }

    public String getSalon_clase() {
        return salon_clase;
    }

    public GrupoEntity getGrupo_id() {
        return grupo_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDia_horario(String dia_horario) {
        this.dia_horario = dia_horario;
    }

    public void setInicio_clase(long inicio_clase) {
        this.inicio_clase = inicio_clase;
    }

    public void setFin_clase(long fin_clase) {
        this.fin_clase = fin_clase;
    }

    public void setSalon_clase(String salon_clase) {
        this.salon_clase = salon_clase;
    }

    public void setGrupo_id(GrupoEntity grupo_id) {
        this.grupo_id = grupo_id;
    }
    
    
}
