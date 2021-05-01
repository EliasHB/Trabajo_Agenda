package com.mycompany.trabajo_agenda_fxmaven;

public class Menu {

    public static void main(String[] args) {
        Output callOut = new Output();
        Input callIn = new Input();
        Grupo elGrupo = new Grupo();
        int variable = 0;
        while (variable != 7) {
            callOut.printmenu();
            variable = callIn.setInt();
            switch (variable) {
                case 1:
                    elGrupo.add();
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
                            elGrupo.binaryFile();
                            elGrupo.writeFile();
                            break;
                        case 2:
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
