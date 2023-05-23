package bloque01_Hilos_EjercicioRecu.c_mayo05;

import javax.swing.*;

public class VistaCliente {
    private JPanel pnlP;
    private JLabel lblNombre;
    public JTextField txfNombre;
    public JButton btnPersona;
    public JButton btnLista;
    public JTextArea txtArea;

    public VistaCliente() {
        JFrame frame = new JFrame("VistaCliente");
        frame.setContentPane(pnlP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        VistaCliente vistaCliente = new VistaCliente();
        ControladorCliente controladorCliente = new ControladorCliente(vistaCliente);
    }
}
