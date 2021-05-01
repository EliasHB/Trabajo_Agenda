package com.mycompany.trabajo_agenda_fxmaven;

import java.io.Serializable;



public class Personaje implements Comparable<Personaje>, Serializable{

    private String nombre;
    private int strength;
    private int speed;
    private int resistance;
    private Input callIn = new Input();

    public String setNombre() {
        nombre = callIn.setFrase();
        return nombre;
    }

    public String setNombre(String x) {
        nombre = x;
        return nombre;
    }

    public int setStrength() {
        strength = callIn.setInt();
        return strength;
    }

    public int setStrength(int x) {
        strength = x;
        return strength;
    }

    public int setSpeed() {
        speed = callIn.setInt();
        return speed;
    }

    public int setSpeed(int x) {
        speed = x;
        return speed;
    }

    public int setResistance() {
        resistance = callIn.setInt();
        return resistance;
    }

    public int setResistance(int x) {
        resistance = x;
        return resistance;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getResistance() {
        return this.resistance;
    }

    @Override
    public int compareTo(Personaje o) {
        return this.nombre.compareToIgnoreCase(o.nombre);
    }

    

}
