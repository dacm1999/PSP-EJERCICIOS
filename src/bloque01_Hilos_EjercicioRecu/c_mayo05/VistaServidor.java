package bloque01_Hilos_EjercicioRecu.c_mayo05;

import javax.swing.*;

public class VistaServidor {
    private JPanel pnlP;
    public JTextField txfNombre;
    private JLabel lblEdad;
    private JLabel lblNombre;
    public JTextField txfEdad;
    public JButton btnCrear;
    public JButton btnMostrar;

    public VistaServidor() {
        JFrame frame = new JFrame("VistaServidor");
        frame.setContentPane(pnlP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(300,150);
    }

    public static void main(String[] args) {
        VistaServidor vistaServidor = new VistaServidor();
        ControladorServidor controladorServidor = new ControladorServidor(vistaServidor);
        controladorServidor.start();
    }
}
