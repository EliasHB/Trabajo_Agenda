package trabajo_.agenda;

public class Menu {

    public static void main(String[] args) {
        Output callOut = new Output();
        Input callIn = new Input();
        Grupo elGrupo = new Grupo(2);
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
                    break;
                case 5:
                    callOut.printSubMenu();
                    variable = callIn.setInt();
                    switch (variable) {
                        case 1:
                            elGrupo.writeFile();
                            break;
                        case 2:
                            elGrupo.readFile();
                            break;
                        default:
                            break;
                    }
                case 6:
                    break;
            }
        }

    }

}
