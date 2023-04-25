package bloque01_Hilos.Ejercicio05;

import java.util.Scanner;

public class Ejercicio05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un tiempo ");
        int tiempo = sc.nextInt();

        Temporizador5 temporizador5 = new Temporizador5(tiempo);
        temporizador5.start();

        System.out.println("¿Desas parar el hilo? " + "\n" +"S/N");
        String seleccion = sc.nextLine();

        temporizador5.parar();
    }
}
