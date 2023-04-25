package bloque01_Hilos.Ejercicio05;

public class Temporizador5  extends Thread{

    private int tiempo;
    private boolean ejecucion;

    public Temporizador5(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        ejecucion = true;
        for(int i =0; i < tiempo; i ++){

            try {
                sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {

            }
        }
    }


    public void parar(){
        ejecucion = false;
    }
}
