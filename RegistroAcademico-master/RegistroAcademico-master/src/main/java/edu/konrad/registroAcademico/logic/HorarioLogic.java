/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.logic;

import edu.konrad.registroAcademico.entities.HorarioEntity;
import edu.konrad.registroAcademico.persistence.HorarioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Carlos David
 */
@Stateless
public class HorarioLogic {
    
    @Inject
    private HorarioPersistence horarioPersistence;
    
    /**
      * método que permite Obtener el listado de horarios
      * @return horarios
      */
    public List<HorarioEntity> getHorarios(){
        List<HorarioEntity> horarios = horarioPersistence.findAll();
        return horarios;
    }
    
    /**
      * método que permite Obtener un Horario a traves de su Id
      * @param Id
      * @return Horario
      */
    public HorarioEntity getHorario (Long Id){
        HorarioEntity horario= horarioPersistence.find(Id);
        if (horario == null){
            throw new IllegalArgumentException("El horario que busca no existe");
        }
        return horario;
    }
    
    /**
      * método que permite Crear un nuevo horario
      * @param horarioEntity
      * @return horarioEntity
      */
    public HorarioEntity createHorario(HorarioEntity horarioEntity){
        horarioPersistence.create(horarioEntity);
        return horarioEntity;
    }
    
    /**
      * método que permite Actualizar horario
      * @param id
      * @param horarioEntity
      * @return horario
      */
    public HorarioEntity update(Long id, HorarioEntity horarioEntity){
        HorarioEntity horario = horarioPersistence.update(horarioEntity);
        return horario;
    }
    
    /**
      * método que permite Eliminar un horario por su Id
      * @param id 
      */
    public void deleteHorario(Long id){
        horarioPersistence.remove(id);
    }
    
}
