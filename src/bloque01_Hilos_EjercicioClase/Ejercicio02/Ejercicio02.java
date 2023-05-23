package bloque01_Hilos_EjercicioClase.Ejercicio02;

public class Ejercicio02 {

    public static void main(String[] args) {
        Contador2 contador1 = new Contador2("Hilo1", 15);
        Contador2 contador2 = new Contador2("Hilo2", 25);
        Contador2 contador3 = new Contador2("Hilo3", 20);

        Thread hilo1 = new Thread(contador1);
        Thread hilo2 = new Thread(contador2);
        Thread hilo3 = new Thread(contador3);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        System.out.println("Hilo " + Thread.currentThread().getName());
    }
}
