package Examenes.c_RecuperaciónFebrero.Ejercicio01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Controlador implements ActionListener {

    Ejercicio01 vista;
    private Thread hilo;
    private boolean pausar;


    public Controlador(Ejercicio01 vista) {
        this.vista = vista;
        addListeners();
    }

    public void addListeners(){
        vista.btnAceptar.addActionListener(this);
        vista.btnPausar.addActionListener(this);
        vista.btnDetener.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comandos = e.getActionCommand();


        switch (comandos){

            case "Aceptar":{
                if (hilo == null || !hilo.isAlive()) {
                    hilo = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (!Thread.currentThread().isInterrupted()) {
                                try {
                                    SwingUtilities.invokeAndWait(new Runnable() {
                                        @Override
                                        public void run() {
                                            String ruta = vista.txfRuta.getText();
                                            File directorio = new File(ruta);
                                            if (directorio.exists() && directorio.isDirectory()) {
                                                String[] files = directorio.list();
                                                vista.txtLista.setText("");
                                                for (String file : files) {
                                                    vista.txtLista.append(file + "\n");
                                                }
                                            }
                                        }
                                    });
                                    Thread.sleep(1000); // Comprobación cada segundo
                                } catch (InterruptedException ex) {
                                    Thread.currentThread().interrupt();
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    });
                    hilo.start();
                }
            }
            break;

            case "Detener":{
                if (hilo != null && hilo.isAlive()) {
                    hilo.interrupt();
                    hilo = null;
                }
            }
            break;

            case "Pausar":{
                if (hilo != null && hilo.isAlive()) {
                    if (!pausar) {
                        hilo.suspend();
                        pausar = true;
                        vista.btnPausar.setText("Reanudar");
                    } else {
                        hilo.resume();
                        pausar = false;
                        vista.btnPausar.setText("Pausar");
                    }
                }

            }
            break;
        }
    }
}
