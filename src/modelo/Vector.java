package modelo;

public class Vector {

    private int[] vector;

    public Vector(int tamaño) {
        this.vector = new int[tamaño];
    }

    public int[] getVector() {
        return vector;
    }

    public int getTamaño() {
        int j = 0;
        for(int i = 0; i < vector.length; i++){
            if (vector[i] != 0){
               j++;
            }
        }
        return j;
    }

    public void setVector(int[] vector) {
        this.vector = vector;
    }

    public void llenarVector() {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 9) + 1;
        }
    }

    public void mostrarVector() {
        System.out.println("");
        System.out.print("[");
        for (int i = 0; i < vector.length; i++) {

            if (i < vector.length - 1) {
                System.out.print(vector[i] + ", ");
            } else {
                System.out.print(vector[i]);
            }

        }
        System.out.print("]");
    }

    public int sumarVector() {
        int suma = 0;
        for (int i = 0; i < vector.length; i++) {
            suma += vector[i];
        }
        return suma;
    }

    public int mayorVector() {
        int mayor = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] > mayor) {
                mayor = vector[i];
            }
        }
        return mayor;
    }

    public int getPosition(int pos) {
        int resultado = -1;
        int i = -1;
        for (int j = 0; j < vector.length; j++) {
            if (vector[j] != 0) {
                i++;
            }
            if (i == pos) {
                resultado = j;
                break;
            }
            
        }

        return resultado;
    }

    public int menorVector() {
        int menor = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] < menor) {
                menor = vector[i];
            }
        }
        return menor;
    }

    public int promedioVector() {
        int suma = sumarVector();
        return suma / vector.length;
    }

    public int[] ordenarVector() {
        int[] vectorOrdenado = vector.clone();
        for (int i = 0; i < vectorOrdenado.length - 1; i++) {
            for (int j = 0; j < vectorOrdenado.length - 1; j++) {
                if (vectorOrdenado[j] > vectorOrdenado[j + 1]) {
                    int aux = vectorOrdenado[j];
                    vectorOrdenado[j] = vectorOrdenado[j + 1];
                    vectorOrdenado[j + 1] = aux;
                }
            }
        }
        return vectorOrdenado;
    }

    public int buscarVector(int numero) {
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == numero) {

            }

        }
        return 0;
    }

    public int CalculaTamañoNewVector() {

        if (this.getTamaño() % 2 == 0) {
            int res = this.getTamaño() / 2;
            return res;
        } else {
            int res = (this.getTamaño() / 2) + 1;
            return res;
        }
    }

    public void agregarResultado(int resultado, int posicion) {

        this.vector[posicion] = resultado;

    }

}
