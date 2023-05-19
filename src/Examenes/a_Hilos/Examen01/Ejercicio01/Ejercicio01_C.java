package Examenes.a_Hilos.Examen01.Ejercicio01;

import java.util.Scanner;

public class Ejercicio01_C {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de hilos a crear: ");
        int cantidadHilos = scanner.nextInt();

        for (int i = 0; i < cantidadHilos; i++) {
            int inicio = i * 10;
            int fin = (i * 10) + 10;

            Thread hilo = new Thread(new HilosContadores(inicio, fin));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            hilo.start();
        }

        scanner.close();
    }
}
