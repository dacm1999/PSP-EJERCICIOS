package bloque01_Hilos_EjercicioRecu.a_marzo15;

public class Ejercicio06 {

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
                System.out.println("Hilo1 " +  " terminado" );
            }
        });
        System.out.println("Hilo " + hilo1.getName() + " iniciado");
        hilo1.start();

        try {
            hilo1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
        hilo2.start();


        System.out.println("Hilo main terminado");
    }
}
