package bloque01_Hilos_EjercicioRecu.a_marzo15;

public class Ejercicio03 {

    public static void main(String[] args) {

        System.out.println("Hilo main iniciado ");
        for(int i = 0; i < 20; i++){
            System.out.println(i);
        }

        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i = 0; i < 10; i++){
                    System.out.println(i);
                }
            }
        });

        if(Thread.currentThread().isAlive()) {
            System.out.println("Espere");
        }


        System.out.println("Hilo " + hilo.getName() + " iniciado");
        hilo.start();


    }
}
