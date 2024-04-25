package modelo;

import java.util.ResourceBundle.Control;

import controlador.ControladorPrincipal;

public class Hilo extends Thread{

    private int numero1;
    private int numero2;
    private int resultado;
    private int id;
    private int posicion;

    private ControladorPrincipal controlador;

    public Hilo(int i) {
        this.id = i;
    }

    public int getindex() {
        return id;
    }



    @Override
    public void run() {
//Obtienen el resultado de su suma
        this.resultado = this.numero1 + this.numero2;
        //Mandan ese resultado a el nuevo vector

        this.controlador.agregarResultado(resultado, this.posicion);
    }



    public void setControlador(ControladorPrincipal controladorPrincipal) {

        this.controlador = controladorPrincipal;
    }



    public void setNumero1(int i) {

        this.numero1 = i;
    }



    public void setNumero2(int i) {

        this.numero2 = i;
    }

    public void setposicion(int i) {
        this.posicion = i;
    }

}
