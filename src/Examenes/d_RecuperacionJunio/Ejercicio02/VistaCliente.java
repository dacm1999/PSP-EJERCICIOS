package Examenes.d_RecuperacionJunio.Ejercicio02;

import javax.swing.*;

public class VistaCliente {
    public JPanel pnlP;
    public JTextField txfRuta;
    public JLabel lbl1;
    public JTextField txfTipo;
    public JLabel lblRecibido;
    public JLabel lbl2;
    public JButton btnAceptar;
    private JPanel pnl;
    public JButton btnSalir;


    public VistaCliente() {
        JFrame frame = new JFrame("Cliente");
        frame.setContentPane(pnlP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(350,200);
    }

    public static void main(String[] args) {

        VistaCliente vistaCliente = new VistaCliente();
        ControladorCliente controladorCliente = new ControladorCliente(vistaCliente);
    }
}
