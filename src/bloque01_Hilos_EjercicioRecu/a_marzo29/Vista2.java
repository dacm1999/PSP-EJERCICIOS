package bloque01_Hilos_EjercicioRecu.a_marzo29;

import javax.swing.*;

public class Vista2 {
    private JPanel pnpL;
    private JPanel pnlp;
    public JTextField txfTiempo1;
    public JLabel lbl1;
    public JLabel lbl2;
    public JTextField txfTiempo2;
    public JProgressBar progreso1;
    public JProgressBar progreso2;
    public JButton btnAceptar1;
    public JButton btnAceptar2;

    public Vista2() {

        JFrame frame = new JFrame("Vista2");
        frame.setContentPane(pnpL);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(300,200);
    }

    public static void main(String[] args) {

        Vista2 vista = new Vista2();
        ControladorVista2 controladorVista2 = new ControladorVista2(vista);
    }
}
