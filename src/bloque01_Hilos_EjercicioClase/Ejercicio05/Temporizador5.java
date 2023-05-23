package bloque01_Hilos_EjercicioClase.Ejercicio05;

public class Temporizador5 extends Thread {

    private int tiempo;
    private boolean ejecucion;

    public Temporizador5(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        ejecucion = true;
        int contador = 0;
        while(contador < tiempo && ejecucion){
            System.out.println(contador++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void parar() {
        ejecucion = false;
    }
}
