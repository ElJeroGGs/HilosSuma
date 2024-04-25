package vista;

import java.util.Scanner;

public class VistaPrincipal {
    private int tamaño = 0;

    public VistaPrincipal() {

       

        Scanner sc = new Scanner(System.in);
        System.out.println("¿De que tamaño quieres tu vector?");
        int scan = sc.nextInt();
        this.tamaño = scan;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
}
