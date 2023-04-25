package bloque01_Hilos.Ejercicio03;

import java.util.Scanner;

public class Ejercicio04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int temp = 0;

        do{
            System.out.println("Introduce un tiempo");
            temp = sc.nextInt();

            Temporizador temporizador = new Temporizador(temp);
            temporizador.run();
        }while (temp > 0);

        System.out.println("Hilo " + Thread.currentThread().getName() + " terminado");
    }
}
