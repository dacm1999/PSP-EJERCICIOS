package bloque01_Hilos_EjercicioRecu.a_marzo29;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista {
    private JPanel pnlp;
    private JTextField txfTiempo1;
    private JLabel lbl1;
    private JLabel lbl2;
    private JTextField txfTiempo2;
    private JProgressBar progreso1;
    private JProgressBar progreso2;
    private JButton btnAceptar1;
    private JButton btnAceptar2;
    private boolean ejecutando1;
    private boolean ejecutando2;


    public Vista() {

        btnAceptar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAceptar1.setEnabled(false);
                int tiempo = Integer.parseInt(txfTiempo1.getText());

                Thread hilo1 = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        for (int i = 1; i <= tiempo; i++) {
                            int contador = i;
                            actualizarbarraylabel(contador, tiempo);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }

                        }
                        btnAceptar1.setEnabled(true);

                    }
                });
                hilo1.start();
            }
        });

        btnAceptar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                btnAceptar2.setEnabled(false);
                int tiempo = Integer.parseInt(txfTiempo2.getText());

                Thread hilo = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 0; i <= tiempo; i ++){
                            int contador = i;
                            actualizarBarrayLabel2(contador,tiempo);
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        btnAceptar2.setEnabled(true);
                    }

                });
                hilo.start();
            }
        });
    }

    private void actualizarbarraylabel(int contador, int tiempo) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                lbl1.setText(contador + "");
                int valor = (int) ((float) contador / tiempo * 100);
                progreso1.setValue(valor);

            }
        });
    }

    private void actualizarBarrayLabel2(int contador, int tiempo){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                lbl2.setText(contador+"");
                int valor = (int) ((float)contador / tiempo * 100);
                progreso2.setValue(valor);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vista");
        frame.setContentPane(new Vista().pnlp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(300,200);
    }
}
