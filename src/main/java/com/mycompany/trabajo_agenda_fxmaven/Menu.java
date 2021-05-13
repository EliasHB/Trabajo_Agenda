package com.mycompany.trabajo_agenda_fxmaven;

import java.io.IOException;

public class Menu {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Output callOut = new Output();
        Input callIn = new Input();
        Grupo elGrupo = new Grupo();
        int variable = 0;
        while (variable != 7) {
            callOut.printmenu();
            variable = callIn.setInt();
            switch (variable) {                
                case 1:
                    callOut.printAtrib();
                    String name = callIn.setFrase();
                    int strength = callIn.setInt();
                    int speed = callIn.setInt();
                    int resis = callIn.setInt();
                    elGrupo.add(name, strength, speed, resis);
                    break;
                case 2:
                    elGrupo.remove();
                    break;
                case 3:
                    elGrupo.watch();
                    break;
                case 4:
                    elGrupo.search();
                    break;
                case 5:
                    elGrupo.orderListByName();
                    break;
                case 6:
                    callOut.printSubMenuFiles();
                    variable = callIn.setInt();
                    switch (variable) {
                        case 1:
                            elGrupo.binaryFileWrite();
                            elGrupo.writeFile();
                            break;
                        case 2:
                            Grupo.binaryFileRead();
                            elGrupo.readFile();
                            break;
                        case 3:
                            elGrupo.fromFileToArray();
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }

    }

}
