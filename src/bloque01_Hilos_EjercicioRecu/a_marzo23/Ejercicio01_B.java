package bloque01_Hilos_EjercicioRecu.a_marzo23;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio01_B {
    private JPanel pnlp;
    public JLabel lbl1;
    public JButton aceptarButton;
    public JTextField txfTiempo;
    public JLabel lbl2;
    private JPanel pnl;

    public Ejercicio01_B() {

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                aceptarButton.setEnabled(false);
                Thread hilo = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int tiempo = Integer.parseInt(txfTiempo.getText());

                        for (int i = 0; i <= tiempo; i++) {
                            int finalI = i;
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(100);
                                        lbl1.setText(String.valueOf(finalI));
                                    } catch (InterruptedException ex) {
                                        throw new RuntimeException(ex);
                                    }

                                }
                            });
                        }
                    }
                });
                Thread hilo2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int tiempo = Integer.parseInt(txfTiempo.getText());
                        for (int i = 0; i <= tiempo; i++) {
                            int finalI = i;
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(100);
                                        lbl2.setText(String.valueOf(finalI));
                                    } catch (InterruptedException ex) {
                                        throw new RuntimeException(ex);
                                    }

                                }
                            });
                        }
                    }
                });



                hilo.start();
                if(!hilo.isAlive()){
                    aceptarButton.setEnabled(true);
                }
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejercicio01_B");
        frame.setContentPane(new Ejercicio01_B().pnl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
