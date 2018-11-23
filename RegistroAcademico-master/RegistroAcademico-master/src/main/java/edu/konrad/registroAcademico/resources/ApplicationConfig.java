/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.konrad.registroAcademico.resources;


import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Clase para el registro de recursos
 * @author johanna
 */

@ApplicationPath("/api")
public class ApplicationConfig  extends Application{
    
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources){
        resources.add(edu.konrad.registroAcademico.resources.CoordinadorResources.class);
        resources.add(edu.konrad.registroAcademico.resources.CursoResources.class);
        resources.add(edu.konrad.registroAcademico.resources.EstudianteResources.class);
        resources.add(edu.konrad.registroAcademico.resources.FacultadResources.class);
        resources.add(edu.konrad.registroAcademico.resources.GrupoResources.class);
        resources.add(edu.konrad.registroAcademico.resources.HorarioResources.class);
        resources.add(edu.konrad.registroAcademico.resources.InscripcionResources.class);
        resources.add(edu.konrad.registroAcademico.resources.PersonaResources.class);
        resources.add(edu.konrad.registroAcademico.resources.ProfesorResources.class);
        resources.add(edu.konrad.registroAcademico.resources.ProgramaResources.class);
    }
}
