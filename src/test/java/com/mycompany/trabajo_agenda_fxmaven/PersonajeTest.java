/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabajo_agenda_fxmaven;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author W10
 */
public class PersonajeTest {
    
    @Test
    public void testName() {
        Personaje x = new Personaje();
        assertEquals("a", x.setNombre("a"));
        
    }
    

    @Test
    public void testStrength() {
        Personaje x = new Personaje();
        assertEquals(1, x.setStrength(1));
        
    }
    @Test
    public void testSpeed() {
        Personaje x = new Personaje();
        assertEquals(1, x.setSpeed(1));
        
    }
}
