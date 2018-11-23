/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.dto;

import edu.konrad.registroAcademico.entities.PersonaEntity;
import edu.konrad.registroAcademico.entities.ProfesorEntity;
import edu.konrad.registroAcademico.entities.ProgramaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos David
 */
public class ProfesorDTO {
    
    /**
     * Atributo que hace referencia al id del objeto Profesor
     */
    private Long id;
    
    /**
     * Atributo de la tabla Profesor que hace referencia a la columna del codigo del profesor
     */
    private String cod_profesor;
    
    /**
     * Atributo de la tabla Profesor que hace referencia a la columna codigo de la persona
     */
    private PersonaEntity persona_id;
    
    /**
     * Atributo de la tabla Profesor que hace referencia a la columna codigo del programa
     */
    private ProgramaEntity programa_id;
    
    /**
     * Atributo de la tabla Profesor que hace referencia a la columna del area 
     * de profundización del docente.
     */
    private String area_profundizacion;
    
    /**
      * mapeo de tabla a objeto
      * @param profesorEntity
      */
    public ProfesorDTO(ProfesorEntity profesorEntity){
        this.id = profesorEntity.getId_profesor();
        this.cod_profesor = profesorEntity.getCod_profesor();
        this.persona_id = profesorEntity.getPERSONA_id_fk();
        this.programa_id = profesorEntity.getPROGRAMA_id_fk();
        this.area_profundizacion = profesorEntity.getArea_profundizacion();
    }
    
    /**
      * Mapeo de objeto a tabla
      * @return 
      */
    public ProfesorEntity toEntity(){
       ProfesorEntity entity = new  ProfesorEntity();
       entity.setId_profesor(this.id);
       entity.setCod_profesor(this.cod_profesor);
       entity.setPERSONA_id_fk(this.persona_id);
       entity.setPROGRAMA_id_fk(this.programa_id);
       entity.setArea_profundizacion(this.area_profundizacion);
       return entity;
    }
    
    /**
     * Conversor lista entidad profesor a lista de objetos profesor
     * @param profesorEntitys
     * @return listaObjetoProfesor
     */
    public static List<ProfesorDTO> toListProfesor(List<ProfesorEntity> profesorEntitys){
        List<ProfesorDTO> listaObjetoProfesor = new ArrayList<>();
        for(int i=0; i<profesorEntitys.size();i++ ){
            listaObjetoProfesor.add(new ProfesorDTO (profesorEntitys.get(i)));
        }
        return listaObjetoProfesor;
    }  
    
    /**
     * Constructor por defecto
     */

    public ProfesorDTO() {
    }
    

    /**
     * Métodos get y set
     */
    public Long getId() {
        return id;
    }

    public String getCod_profesor() {
        return cod_profesor;
    }

    public PersonaEntity getPersona_id() {
        return persona_id;
    }

    public ProgramaEntity getPrograma_id() {
        return programa_id;
    }

    public String getArea_profundizacion() {
        return area_profundizacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCod_profesor(String cod_profesor) {
        this.cod_profesor = cod_profesor;
    }

    public void setPersona_id(PersonaEntity persona_id) {
        this.persona_id = persona_id;
    }

    public void setPrograma_id(ProgramaEntity programa_id) {
        this.programa_id = programa_id;
    }

    public void setArea_profundizacion(String area_profundizacion) {
        this.area_profundizacion = area_profundizacion;
    }
}
