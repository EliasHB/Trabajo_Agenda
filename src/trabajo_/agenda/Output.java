package trabajo_.agenda;

public class Output {

    public void printmenu() {
        System.out.println("--------------------------");
        System.out.println("-  1 Añadir datos        -");
        System.out.println("-  2 Borrar datos        -");
        System.out.println("-  3 Ver contenido       -");
        System.out.println("-  4 Ordenar datos       -");
        System.out.println("-  5 Opciones de fichero -");
        System.out.println("-  6 Salir               -");
        System.out.println("--------------------------");
    }

    public void printSubMenu() {
        System.out.println("-  1 Importar fichero    -");
        System.out.println("-  2 Exportar fichero    -");
        System.out.println("-  3 Salir               -");
    }

    public void printName() {
        System.out.println("Introduzca nombre:");
    }

    public void printStrength() {
        System.out.println("Introduzca valor de fuerza:");
    }

    public void printSpeed() {
        System.out.println("Introduzca valor de velocidad:");
    }

    public void printResistance() {
        System.out.println("Introduzca valor de resistencia:");
    }

    public void printOutOfSpace() {
        System.out.println("Tabla llena");
    }

    public void printEmpty() {
        System.out.println("Tabla vacia");
    }

    public void printData(String x) {
        System.out.print(x + " ");
    }

    public void printData(int x) {
        System.out.print(x + " ");
    }
    public void printLineJump(){
        System.out.println();
    }
    public void printWriterException(){
        System.out.println("No hay fichero para escribir");
    }
    public void printReaderException(){
        System.out.println("No hay fichero para leer");
    }
}
