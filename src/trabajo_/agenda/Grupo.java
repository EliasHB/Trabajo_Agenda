package trabajo_.agenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Grupo implements Comparable<Personaje> {

    private Personaje[] personajes;
    private int tamReal;
    private Personaje personaje;
    private Output callOut = new Output();

    Grupo(int tamMax) {
        personajes = new Personaje[tamMax];
        tamReal = 0;

    }

    public void add() {
        personaje = new Personaje();
        if (tamReal < personajes.length) {
            callOut.printName();
            personaje.setNombre();
            callOut.printStrength();
            personaje.setStrength();
            callOut.printSpeed();
            personaje.setSpeed();
            callOut.printResistance();
            personaje.setResistance();
            personajes[tamReal] = personaje;
            tamReal++;
        } else {
            callOut.printOutOfSpace();
        }
    }

    public void remove() {
        if (tamReal > 0) {
            tamReal--;
        } else {
            callOut.printEmpty();
        }

    }

    public void watch() {
        if (tamReal > 0) {
            for (int i = 0; i < tamReal; i++) {
                callOut.printData(personajes[i].getNombre());
                callOut.printData(personajes[i].getStrength());
                callOut.printData(personajes[i].getSpeed());
                callOut.printData(personajes[i].getResistance());
                callOut.printLineJump();
            }
        } else {
            callOut.printEmpty();
        }

    }

    @Override
    public int compareTo(Personaje o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void writeFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Data.txt"));
        } catch (IOException ex) {
            callOut.printWriterException();
        }
    }

    public void readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
        } catch (FileNotFoundException ex) {
            callOut.printReaderException();
        }

    }

}
