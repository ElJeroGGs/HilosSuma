package controlador;


import vista.VistaPrincipal;
import modelo.Hilo;
import modelo.Vector;

public class ControladorPrincipal {

    private Vector vector;
    int SizeNewVector;

    private VistaPrincipal vista;

    public void setVista(VistaPrincipal vista) {
        this.vista = vista;
    }

    public void iniciar() {
        System.out.println("El tamaño del vector es: " + vista.getTamaño());
        // Llena el vector con numeros aleatorios
        Vector Vec = new modelo.Vector(vista.getTamaño());
        Vec.llenarVector();

        Suma(Vec);
        

    }

    public void Suma(Vector vec){

        vec.mostrarVector();
        SizeNewVector = vec.CalculaTamañoNewVector();
        //Crea un nuevo vector vacio
        CreaVector();
        //Distribuye la suma a los hilos

        for(int i = 1; i <= SizeNewVector; i++){
            
            Hilo hilo = new Hilo(i);
            if(i<SizeNewVector){
            
            hilo.setControlador(this);

            hilo.setNumero1(vec.getVector()[(i*2)-2]);
            hilo.setNumero2(vec.getVector()[(i*2)-1]);

            } else{

              hilo = new Hilo(i);
                hilo.setControlador(this);

                hilo.setNumero1(vec.getVector()[(i*2)-2]);

                if(vec.getVector().length%2==0){
                hilo.setNumero2(vec.getVector()[(i*2)-1]);
                }else{
                hilo.setNumero2(0);
                }
           
        }
        hilo.start();
        }



        //Muestra el vector con los resultados
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       

        if(vector.getTamaño()!=1){
            Suma(vector);

        }else{
            vector.mostrarVector();
        }

    }

    public void CreaVector(){
        
        vector = new Vector(SizeNewVector);
    }
    

    public void agregarResultado(int resultado, int turno) {

        vector.agregarResultado(resultado, turno);
    }

}
