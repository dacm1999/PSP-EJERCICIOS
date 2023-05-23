package bloque01_Hilos_EjercicioClase.Ejercicio03;

public class Temporizador extends Thread {

    private int tiempo;

    public Temporizador(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public void run() {

        System.out.println("Hilo " + " iniciado");

        for (int i = 0; i < tiempo; i++) {
            try {
                sleep(1000);

            } catch (InterruptedException e) {
                System.out.println("Interrupted exteption");
            }
        }
        System.out.println("Hilo " + " terminado");

    }
}
