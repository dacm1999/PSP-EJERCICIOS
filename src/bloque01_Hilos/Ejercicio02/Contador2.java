package bloque01_Hilos.Ejercicio02;

public class Contador2 implements Runnable{

    String nombre;
    int cantidad;

    public Contador2(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        System.out.println("Hilo " + nombre + " iniciado ");
        for(int i =0; i < cantidad; i++){
            System.out.println("Hilo " + nombre + " -> " + i);
        }
        System.out.println("Hilo " + nombre + " terminado ");
    }
}
