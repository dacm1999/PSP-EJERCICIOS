package Examenes.a_Hilos.Examen01.Ejercicio01;

public class Ejercicio01_A {

    public static void main(String[] args) {


        Thread hilo1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hilo1 iniciado");
                for (int i = 0; i <= 10; i++) {

                    try {
                        Thread.sleep(1000);
                        System.out.println(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        hilo1.start();


        System.out.println("Hilo principal");

        try {
            hilo1.join();
            for (int i = 10; i <= 20; i++) {

                try {
                    Thread.sleep(500);
                    System.out.println(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Hilo 2 iniciado");
        Thread hilo2 = new Thread(new Runnable() {
            @Override

            public void run() {
                for (int i = 20; i <= 30; i++) {

                    try {
                        Thread.sleep(500);
                        System.out.println(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        hilo2.start();


    }
}
