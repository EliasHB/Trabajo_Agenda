/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabajo_agenda_fxmaven;

import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author W10
 */
@XmlRootElement (name = "Personajes")
public class PersonajeSetWrapper {
    
    private Set<Personaje> personajes;
    
    @XmlElement (name = "Personaje")
    public Set<Personaje> getPersonajes(){
        return personajes;
    }
    public void setPersonajes(Set<Personaje> personajes){
        this.personajes = personajes;
    }
}
