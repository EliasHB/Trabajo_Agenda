package com.mycompany.trabajo_agenda_fxmaven;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Grupo")
public class Grupo implements Serializable {

    @XmlElement(name = "Lista")
    private final ArrayList<Personaje> group = new ArrayList<>();
    private Personaje personaje;
    private final Output callOut = new Output();
    private final Input callIn = new Input();

    public Grupo() {
    }

    public void add(String name, int strength, int speed, int resis) {
        personaje = new Personaje();
        personaje.setNombre(name);
        personaje.setStrength(strength);
        personaje.setSpeed(speed);
        personaje.setResistance(resis);
        group.add(personaje);
    }

    public void remove(int x) {
        group.remove(x);
    }

    public void watchtextmode() {
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

    public String watch() {
        String result = "";
        for (int i = 0; i < group.size(); i++) {
            String a1 = group.get(i).getNombre();
            int a2 = group.get(i).getStrength();
            int a3 = group.get(i).getSpeed();
            int a4 = group.get(i).getResistance();
            result = result + a1 + " " + a2 + " " + a3 + " " + a4 + System.lineSeparator();
        }
        return result;

    }

    public void searchtextmode() {
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

    public String search(String x) {
        String result = "";
        for (int i = 0; i < group.size(); i++) {
            if (x.equals(group.get(i).getNombre())) {
                result = result + group.get(i).getNombre() + " " + group.get(i).getStrength()
                        + " " + group.get(i).getSpeed() + " " + group.get(i).getResistance()
                        + System.lineSeparator();
            }
        }
        return result;
    }

    public void orderListByName() {
        group.sort(new OrderByName());
    }

    public void binaryFileWrite() {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("BData.dat"))) {
            for (int i = 0; i < group.size(); i++) {
                os.writeObject(group.get(i));
            }
        } catch (IOException e) {

        }
    }

    public void binaryFileRead() throws ClassNotFoundException, FileNotFoundException {
        group.clear();
        try {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream("BData.dat"));
            Personaje pjnew = (Personaje) oi.readObject();
            while (true) {
                group.add(pjnew);
                pjnew = (Personaje) oi.readObject();

            }
        } catch (IOException e) {
            e.getMessage();
        }

    }

    public void writeFile() {
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Data.txt"))) {
                for (int i = 0; i < group.size(); i++) {
                    writer.write(group.get(i).getNombre() + "#");
                    writer.write(group.get(i).getStrength() + "#");
                    writer.write(group.get(i).getSpeed() + "#");
                    writer.write(group.get(i).getResistance() + "");
                    writer.newLine();
                }
            }
        } catch (IOException ex) {
            callOut.printWriterException();
        }
    }

    public void readFile() {
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader("Data.txt"))) {
                String line = reader.readLine();
                while (line != null) {
                    String[] linesplit = line.split("#");
                    callOut.printData(Arrays.toString(linesplit));
                    callOut.printLineJump();
                    line = reader.readLine();
                }
            }
        } catch (IOException ex) {
            callOut.printReaderException();
        }

    }

    public void fromFileToArray() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Data.txt"))) {
            String line = reader.readLine();
            group.clear();
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
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public Personaje getObjetposition(int pos) {
        return group.get(pos);
    }

    public void saveXML() throws JAXBException {
        File fileXML = new File("XMLdata.xml");
        JAXBContext context = JAXBContext.newInstance(Grupo.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(this, fileXML);
    }

    public static Grupo loadXML() throws JAXBException {
        File fileXML = new File("XMLdata.xml");
        JAXBContext context = JAXBContext.newInstance(Grupo.class);
        Unmarshaller um = context.createUnmarshaller();
        Grupo nuevoGrupo = (Grupo) um.unmarshal(fileXML);
        return nuevoGrupo;
    }

}
