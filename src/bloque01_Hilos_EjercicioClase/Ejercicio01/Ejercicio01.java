package bloque01_Hilos_EjercicioClase.Ejercicio01;

public class Ejercicio01 {

    public static void main(String[] args) {

        Contador1 contador1 = new Contador1("Hilo1" , 10);
        Contador1 contador2 = new Contador1("Hilo4" , 15);
        Contador1 contador3 = new Contador1("Hilo3" , 20);

        contador1.start();
        contador2.start();
        contador3.start();

        System.out.println("Hilo " + Thread.currentThread().getName() + " terminado");
    }
}
