package Examenes.a_Hilos.Examen01.Ejercicio01;

public class Ejercicio01_B {

    public static void main(String[] args) {


        try {
            System.out.println("Hilo principal iniciado");

            for (int i = 0; i <= 10; i++) {
                System.out.println(i);
            }

            Thread.sleep(2000);


            System.out.println("Hilo 1 iniciado");
            Thread hilo1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 10; i <= 20; i++) {
                        System.out.println(i);
                    }
                }
            });

            hilo1.start();

            Thread.sleep(2000);

            System.out.println("Hilo 2 iniciado");
            Thread hilo2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 20; i <= 30; i++) {
                        System.out.println(i);
                    }
                }
            });

            hilo2.start();



        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
