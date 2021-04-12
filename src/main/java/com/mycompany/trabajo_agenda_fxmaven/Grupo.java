package com.mycompany.trabajo_agenda_fxmaven;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Grupo {

    private ArrayList<Personaje> group = new ArrayList<>();
    private Personaje personaje;
    private Output callOut = new Output();
    private Input callIn = new Input();

    public void add() {

        personaje = new Personaje();
        callOut.printName();
        personaje.setNombre();
        callOut.printStrength();
        personaje.setStrength();
        callOut.printSpeed();
        personaje.setSpeed();
        callOut.printResistance();
        personaje.setResistance();
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
