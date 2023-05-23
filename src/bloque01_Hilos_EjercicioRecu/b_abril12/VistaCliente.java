package bloque01_Hilos_EjercicioRecu.b_abril12;

import javax.swing.*;

public class VistaCliente {
    private JPanel pnlP;
    public JTextField txfMensaje;
    public JButton btnEnviar;
    public JLabel lblRecibido;

    public VistaCliente() {
        JFrame frame = new JFrame("VistaCliente");
        frame.setContentPane(pnlP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300,150);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        VistaCliente vista = new VistaCliente();
        ControladorCliente controladorCliente = new ControladorCliente(vista);
    }
}
