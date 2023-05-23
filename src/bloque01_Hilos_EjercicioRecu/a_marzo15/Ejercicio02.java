package bloque01_Hilos_EjercicioRecu.a_marzo15;

public class Ejercicio02 {
    public static void main(String[] args) {

        System.out.println("Hilo " + Thread.currentThread().getName());
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
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
        hilo.start();


        try {
            hilo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hilo main iniciado");
        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
        System.out.println("Hilo main terminado");

    }
}
