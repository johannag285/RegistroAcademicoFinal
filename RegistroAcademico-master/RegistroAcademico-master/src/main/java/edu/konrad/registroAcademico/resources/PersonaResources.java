/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.resources;

import edu.konrad.registroAcademico.dto.PersonaDTO;
import edu.konrad.registroAcademico.entities.PersonaEntity;
import edu.konrad.registroAcademico.logic.PersonaLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Servicio REST Persona
 * @author johanna
 */

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/personas")
public class PersonaResources {
    
    @EJB
    private PersonaLogic personaLogic;
    
    /**
     * Metodo REST para obtener todas las personas
     * @return lista personaDTO
     */
    @GET
    public List<PersonaDTO> getListaPersona(){
        List<PersonaEntity> personas = personaLogic.getPersonas();
        return PersonaDTO.toListPersona(personas);
    }
    
    /**
     * Servicio para obtener una persona
     * @param id
     * @return PersonaDTO
     */
    @GET
    @Path("{id: \\d+}")
    public PersonaDTO getPersona(@PathParam("id")Long id){
        PersonaEntity persona = personaLogic.getPersona(id);
        if (persona == null){
            throw new RuntimeException("La persona NO existe");
        }
        return new PersonaDTO(persona);
    }
    
    /**
     * Servicio para crear una persona
     * @param personaCrear
     * @return PersonaDTO
     */
    @POST
    public PersonaDTO createPersona(PersonaDTO personaCrear){
        return new PersonaDTO(personaLogic.createPersona(personaCrear.toEntity()));
    }
    
    /**
     * Actualizar una persona
     * @param id
     * @param personaActualizar
     * @return PersonaDTO
     */
    @PUT
    @Path("{id:\\d+}")
    public PersonaDTO updatePersona(@PathParam("id")Long id, PersonaDTO personaActualizar){
        PersonaEntity entity = personaLogic.getPersona(id);
        if(entity == null){
            throw new RuntimeException("La persona NO existe");
        }
        return new PersonaDTO(personaLogic.update(id, personaActualizar.toEntity()));
    }
    
    /**
     * Eliminar una persona
     * @param id 
     */
    @DELETE
    @Path("{personaId:\\d+}")
    public void deletePersona(@PathParam("personaId")Long id){
        PersonaEntity persona = personaLogic.getPersona(id);
        if(persona == null){
            throw new RuntimeException("La persona NO exite");
        }
        personaLogic.deletePersona(id);
    }
}
