package com.mycompany.trabajo_agenda_fxmaven;

import java.util.Scanner;

public class Input {

    private int value;
    private String frase;
    private final Scanner sc = new Scanner(System.in);

    public String setFrase() {
        frase = sc.nextLine();
        sc.nextLine();
        return frase;
    }

    public int setInt() {
        value = sc.nextInt();
        return value;
    }
}
