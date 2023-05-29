package Examenes.d_RecuperacionJunio.Ejercicio01;

import javax.swing.*;

public class VistaFicheros {
    public JPanel pnlp;
    public JTextField txfRuta;
    public JTextField txfTiempo;
    public JButton btnAceptar;
    public JLabel lbl1;
    public JLabel lbl2;
    public JButton btnParar;


    public VistaFicheros() {
        JFrame frame = new JFrame("VistaFicheros");
        frame.setContentPane(pnlp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(350,200);
    }

    public static void main(String[] args) {

        VistaFicheros vista = new VistaFicheros();
        ControladorFicheros controladorFicheros = new ControladorFicheros(vista);
    }
}
