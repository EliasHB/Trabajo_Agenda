package trabajo_.agenda;

import java.util.Comparator;

public class Personaje implements Comparable<Personaje>, Comparator<Personaje> {

    protected String nombre;
    protected int strength;
    protected int speed;
    protected int resistance;
    private Input callIn = new Input();

    public String setNombre() {
        nombre = callIn.setFrase();
        return nombre;
    }

    public int setStrength() {
        strength = callIn.setInt();
        return strength;
    }

    public int setSpeed() {
        speed = callIn.setInt();
        return speed;
    }

    public int setResistance() {
        resistance = callIn.setInt();
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

    @Override
    public int compare(Personaje o1, Personaje o2) {
        int result = 0;
        if (o1.getStrength() < o2.getStrength()) {
            result = -1;
        } else if (o1.getStrength() > o2.getStrength()) {
            result = 1;
        }
        return result;
    }

}
