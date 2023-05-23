package bloque01_Hilos_EjercicioRecu.a_marzo15;

public class Ejercicio05 {

    public static void main(String[] args) {

        Thread hilo1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 15; i++){
                    try {
                        Thread.sleep(1000);
                        System.out.println(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread hilo2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 15; i++){
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
        hilo2.start();


        try {
            hilo1.join();
            hilo2.join();

            System.out.println("Hilo main terminado");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
