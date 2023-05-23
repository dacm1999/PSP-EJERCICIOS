package bloque01_Hilos_EjercicioRecu.a_marzo23;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    private Ejercicio01 vista;
    public Thread hilo;
    public Thread hilo2;

    public Controlador(Ejercicio01 vista) {
        this.vista = vista;
        addListeners();
        hilo = null;
        hilo2 = null;
    }

    private void addListeners() {
        vista.aceptarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comandos = e.getActionCommand();

        switch (comandos) {
            case "Aceptar": {

                vista.aceptarButton.setEnabled(false);
                vista.lbl1.setText("0");
                vista.lbl2.setText("0");

                hilo = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int tiempo = Integer.parseInt(vista.txfTiempo.getText());

                        for (int i = 0; i <= tiempo; i++) {
                            try {
                                Thread.sleep(1000);
                                int finalI = i;
                                SwingUtilities.invokeLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        System.out.println(SwingUtilities.isEventDispatchThread());
                                        vista.lbl1.setText(String.valueOf(finalI));

                                    }
                                });
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                });
                hilo2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int tiempo = Integer.parseInt(vista.txfTiempo.getText());
                        for (int i = 0; i <= tiempo; i++) {
                            try {
                                hilo.join();
                                int finalI = i;
                                Thread.sleep(1000);
                                SwingUtilities.invokeLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        System.out.println(SwingUtilities.isEventDispatchThread());
                                        vista.lbl2.setText("" + finalI);

                                    }
                                });
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                });
                hilo.start();
                hilo2.start();


            }
            break;

            case "Hola": {

            }
            break;
        }
    }

}



