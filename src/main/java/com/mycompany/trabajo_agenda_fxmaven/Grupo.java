package com.mycompany.trabajo_agenda_fxmaven;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Grupo implements Serializable {

    private final ArrayList<Personaje> group = new ArrayList<>();
    private Personaje personaje;
    private final Output callOut = new Output();
    private final Input callIn = new Input();

    public void add(String name, int strength, int speed, int resis) {
        personaje = new Personaje();
        personaje.setNombre(name);
        personaje.setStrength(strength);
        personaje.setSpeed(speed);
        personaje.setResistance(resis);
        group.add(personaje);
    }

    public void remove() {
        int x;
        boolean check = true;
        if (!group.isEmpty()) {
            callOut.removePosition();
            x = callIn.setInt();
            while (check) {
                if (x >= 0 && x < group.size()) {
                    group.remove(x);
                    check = false;
                } else if (x == 9) {
                    check = false;
                } else {
                    callOut.wrong();
                }
            }
        } else {
            callOut.printEmpty();
        }
    }

    public void watch() {
        if (!group.isEmpty()) {
            for (int i = 0; i < group.size(); i++) {
                callOut.printData(group.get(i).getNombre());
                callOut.printData(group.get(i).getStrength());
                callOut.printData(group.get(i).getSpeed());
                callOut.printData(group.get(i).getResistance());
                callOut.printLineJump();
            }
        } else {
            callOut.printEmpty();
        }
    }

    public void search() {
        callOut.printSearch();
        boolean check = true;
        String x = callIn.setFrase();
        for (int i = 0; i < group.size() && check; i++) {
            if (x.equals(group.get(i).getNombre())) {
                callOut.printData(group.get(i).getNombre());
                callOut.printData(group.get(i).getStrength());
                callOut.printData(group.get(i).getSpeed());
                callOut.printData(group.get(i).getResistance());
                callOut.printLineJump();
                check = false;
            }
        }
        if (check) {
            callOut.printSearchNotFound();
        }
    }

    public void orderListByName() {
        group.sort(new OrderByName());
    }

    public void binaryFileWrite(){
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("BData.dat"))) {
            for (int i = 0; i < group.size(); i++) {
                os.writeObject(group.get(i));
            }
        }catch(IOException e){
            
        }
    }

    public static void binaryFileRead() throws ClassNotFoundException, FileNotFoundException {
        try {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream("BData.dat"));
            ArrayList<Personaje> newGruoup = new ArrayList<>();
            while (true) {
                newGruoup.add((Personaje) oi.readObject());
            }
        } catch (IOException e) {
            e.getMessage();
        }

    }

    public void writeFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Data.txt"));
            for (int i = 0; i < group.size(); i++) {
                writer.write(group.get(i).getNombre() + "#");
                writer.write(group.get(i).getStrength() + "#");
                writer.write(group.get(i).getSpeed() + "#");
                writer.write(group.get(i).getResistance() + "");
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
            reader.close();
        } catch (IOException ex) {
            callOut.printReaderException();
        }

    }

    public void fromFileToArray() {
        int x = 0;
        if (!group.isEmpty()) {
            callOut.printLoadAlert();
            callOut.continueLoad();
            x = callIn.setInt();
        }
        if (group.isEmpty() || x == 1) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
                String line = reader.readLine();
                group.removeAll(group);
                while (line != null) {
                    String[] linesplit = line.split("#");
                    int var1 = Integer.parseInt(linesplit[1]);
                    int var2 = Integer.parseInt(linesplit[2]);
                    int var3 = Integer.parseInt(linesplit[3]);
                    personaje = new Personaje();
                    personaje.setNombre(linesplit[0]);
                    personaje.setStrength(var1);
                    personaje.setSpeed(var2);
                    personaje.setResistance(var3);
                    group.add(personaje);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException ex) {
                callOut.printReaderException();
            }
        }

    }
}
