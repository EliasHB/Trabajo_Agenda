package trabajo_.agenda;

public class Personaje {

    private String nombre;
    private int strength;
    private int speed;
    private int resistance;
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

}
