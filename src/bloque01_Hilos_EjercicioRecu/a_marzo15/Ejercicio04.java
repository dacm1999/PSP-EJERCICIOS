package bloque01_Hilos_EjercicioRecu.a_marzo15;

public class Ejercicio04 {

    public static void main(String[] args) {


        Thread hilo = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Hilo1  iniciado");
                for (int i = 0; i <= 20; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(i);
                }
                System.out.println("Hilo1  terminado");
            }
        });
        hilo.start();


        do {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (hilo.isAlive());

    }
}
