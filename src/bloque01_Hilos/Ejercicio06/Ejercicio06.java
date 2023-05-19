package bloque01_Hilos.Ejercicio06;

import javax.swing.*;

public class Ejercicio06 {
    private JPanel pnlp;
    public JButton btnIniciar;
    public JTextField txfTiempo;

    public Ejercicio06(){
        JFrame frame = new JFrame("Ejercicio06");
        frame.setContentPane(pnlp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
