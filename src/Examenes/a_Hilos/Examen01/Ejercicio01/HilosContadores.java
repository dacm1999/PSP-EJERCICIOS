package Examenes.a_Hilos.Examen01.Ejercicio01;

public class HilosContadores extends Thread {

    private int inicio;
    private int fin;
    public HilosContadores(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public void run() {
        for (int i = inicio; i <= fin; i++) {
            System.out.println("Hilo: " + Thread.currentThread().getId() + " - Contador: " + i);
        }
    }
}
