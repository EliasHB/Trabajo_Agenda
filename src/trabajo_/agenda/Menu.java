package trabajo_.agenda;

public class Menu {

    public static void main(String[] args) {
        Output callOut = new Output();
        Input callIn = new Input();
        Grupo elGrupo = new Grupo(10);
        int variable = 0;
        while (variable != 6) {
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
                    callOut.printSubMenuOrder();
                    variable = callIn.setInt();
                    switch (variable) {
                        case 1:
                            elGrupo.orderArrayName();
                            break;
                        case 2:
                            elGrupo.orderArrayStrength();
                            break;
                        default:
                            break;
                    }
                case 5:
                    callOut.printSubMenuFiles();
                    variable = callIn.setInt();
                    switch (variable) {
                        case 1:
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
                default:
                    break;
            }
        }

    }

}
