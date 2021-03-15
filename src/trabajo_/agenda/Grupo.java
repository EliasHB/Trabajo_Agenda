package trabajo_.agenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Grupo {

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

    public void orderArrayName() {
        Arrays.sort(personajes, 0, tamReal);
    }

    public void orderArrayStrength() {
        Arrays.sort(personajes, new Personaje());
    }

    public void writeFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Data.txt"));
            for (int i = 0; i < tamReal; i++) {
                writer.write(personajes[i].getNombre() + "#");
                writer.write(personajes[i].getStrength() + "#");
                writer.write(personajes[i].getSpeed() + "#");
                writer.write(personajes[i].getResistance());
                writer.newLine();
            }
            writer.close();

        } catch (IOException ex) {
            callOut.printWriterException();
        }
    }

    public void readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] linesplit = line.split("#");
                callOut.printData(Arrays.toString(linesplit));
                callOut.printLineJump();
                line = reader.readLine();
            }
        } catch (IOException ex) {
            callOut.printReaderException();
        }

    }
    public void fromFileToArray(){
        
    }
}
