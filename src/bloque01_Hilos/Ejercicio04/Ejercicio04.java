package bloque01_Hilos.Ejercicio04;

import bloque01_Hilos.Ejercicio01.Contador1;

public class Ejercicio04 {

    public static void main(String[] args) {

        Contador1 contador1 = new Contador1("Hilo1" , 1000);
        Contador1 contador2 = new Contador1("Hilo2" , 500);
        Contador1 contador3 = new Contador1("Hilo3" , 500);

        contador1.start();
        contador2.start();
        contador3.start();

        try{
            contador2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Hilo " + Thread.currentThread().getName() + " terminado");

    }
}
