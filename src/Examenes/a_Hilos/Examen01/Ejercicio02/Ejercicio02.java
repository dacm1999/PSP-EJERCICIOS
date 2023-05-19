package Examenes.a_Hilos.Examen01.Ejercicio02;

import javax.swing.*;

public class Ejercicio02 {
    JPanel pnpl;
    JTextField txfHora;
    JTextField txfMinutos;
    JPanel pnlp2;
    public JButton btnActivar;
    JLabel lblHora;
    JLabel lblMinutos;
    JPanel pnp3;
    public JLabel lblPrincipal;


    public Ejercicio02() {
        JFrame frame = new JFrame("Ejercicio02");
        frame.setContentPane(pnpl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
