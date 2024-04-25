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
        // Llena el vector con numeros aleatorios
        Vector Vec = new modelo.Vector(vista.getTamaño());
        Vec.llenarVector();
        this.vector = Vec;
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
            hilo.setposicion(i*2-2);
            
            if(i<SizeNewVector){
            
            hilo.setControlador(this);
            int pos = (i*2)-2;

            int posi = vec.getPosition(pos);
            int posi2 = vec.getPosition(pos+1);

            hilo.setNumero1(vec.getVector()[posi]);
            
            hilo.setNumero2(vec.getVector()[posi2]);

            } else{

              hilo = new Hilo(i);
                hilo.setControlador(this);
                int pos = (i*2)-2;
                int posi = vec.getPosition(pos);
                
                hilo.setNumero1(vec.getVector()[posi]);
                hilo.setposicion(i*2-2);
                if(vec.getTamaño()%2==0){
                int posi2 = vec.getPosition(pos+1);
                hilo.setNumero2(vec.getVector()[posi2]);
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
        
        vector = new Vector(vista.getTamaño());
    }
    
    public int obtenerPosicion(int posicion) {

       return vector.getPosition(posicion);
    }

    public void agregarResultado(int resultado, int posicion) {

        vector.agregarResultado(resultado, posicion);
    }

}
