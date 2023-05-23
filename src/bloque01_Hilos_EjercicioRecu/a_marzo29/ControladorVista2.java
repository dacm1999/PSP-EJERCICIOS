package bloque01_Hilos_EjercicioRecu.a_marzo29;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVista2 implements ActionListener {

    private Vista2 vista;
    private Thread hilo1;
    private Thread hilo2;

    public ControladorVista2(Vista2 vista) {
        this.vista = vista;
        addListeners();
        hilo1 = null;
        hilo2 = null;
    }

    private void addListeners() {
        vista.btnAceptar1.addActionListener(this);
        vista.btnAceptar2.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Hilo1": {

                int tiempo = Integer.parseInt(vista.txfTiempo1.getText());
                vista.btnAceptar1.setEnabled(false);
                hilo1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 0; i <= tiempo; i++){
                            int contador = i;

                            modificarGuiHilo1(contador,tiempo);

                            try{
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        vista.btnAceptar1.setEnabled(true);
                    }
                });
                hilo1.start();
            }
            break;

            case "Hilo2": {
                int tiempo = Integer.parseInt(vista.txfTiempo2.getText());
                vista.btnAceptar2.setEnabled(false);
                hilo2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 0; i <= tiempo; i++){
                            int contador = i;

                            modificarGuiHilo2(contador,tiempo);

                            try{
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        vista.btnAceptar2.setEnabled(true);
                    }
                });
                hilo2.start();
            }
            break;
        }
    }


    private void modificarGuiHilo1(int contador, int tiempo) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                vista.lbl1.setText(contador + "");
                int valor = (int) ((float) contador / tiempo * 100);
                vista.progreso1.setValue(valor);
            }
        });
    }

    private void modificarGuiHilo2(int contador, int tiempo) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                vista.lbl2.setText(contador + "");
                int valor = (int) ((float) contador / tiempo * 100);
                vista.progreso2.setValue(valor);
            }
        });
    }
}
