package Examenes.d_RecuperacionJunio.Ejercicio01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ControladorFicheros implements ActionListener {

    private VistaFicheros vista;
    private String ruta;
    private int tiempo;
    private Thread hilo;
    private boolean ejecutando;

    public ControladorFicheros(VistaFicheros vista) {
        this.vista = vista;
        addListeners();

        ejecutando = true;
    }

    private void addListeners(){
        vista.btnAceptar.addActionListener(this);
        vista.btnParar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando){
            case "Aceptar":{
                System.out.println("ESTOY EN EL EDT " + SwingUtilities.isEventDispatchThread());
                ruta = vista.txfRuta.getText();
                System.out.println(vista.txfRuta.getText());
                tiempo = Integer.parseInt(vista.txfTiempo.getText());
                System.out.println(vista.txfTiempo.getText());
                hilo = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int contador = 0;
                        do{
                            try {
                                contador++;
                                File files = new File(ruta+contador);
                                hilo.sleep(tiempo*1000);
                                files.createNewFile();
                                System.out.println("Fichero creado");
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }while (ejecutando == true);
                    }
                });
                hilo.start();
            }
            break;

            case "Parar":{
                if(ejecutando == true){
                    ejecutando = false;
                    System.out.println("Hilo parado");
                }
            }
            break;
        }
    }

    private void edt(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ruta = vista.txfRuta.getText();
                System.out.println(vista.txfRuta.getText());
                tiempo = Integer.parseInt(vista.txfTiempo.getText());
                System.out.println(vista.txfTiempo.getText());
            }
        });
    }


}
