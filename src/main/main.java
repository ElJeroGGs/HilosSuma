package main;

import controlador.ControladorPrincipal;
import vista.VistaPrincipal;

public class main {

    public static void main(String[] args) {

        VistaPrincipal vista = new VistaPrincipal();
        ControladorPrincipal ctrl = new ControladorPrincipal();
        ctrl.setVista(vista);
        ctrl.iniciar();
    }

}
