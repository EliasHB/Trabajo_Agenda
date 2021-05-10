/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trabajo_agenda_fxmaven;

import java.io.InputStream;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author W10
 */
public class ProyectTest {
    
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
    @Test
    public void testComparator() {
        OrderByName x = new OrderByName();
        Personaje a = new Personaje();
        Personaje b = new Personaje();
        a.setNombre("a");
        b.setNombre("b");
        assertEquals(1, x.compare(b, a));
        
    }
    @Test
    public void testComparator2() {
        OrderByName x = new OrderByName();
        Personaje a = new Personaje();
        Personaje b = new Personaje();
        a.setNombre("a");
        b.setNombre("b");
        assertEquals(-1, x.compare(a, b));
        
    }
    @Test
    public void testComparator3() {
        OrderByName x = new OrderByName();
        Personaje a = new Personaje();
        Personaje b = new Personaje();
        a.setNombre("a");
        b.setNombre("a");
        assertEquals(0, x.compare(a, b));
        
    }
    
}
