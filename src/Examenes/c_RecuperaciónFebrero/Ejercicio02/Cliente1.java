package Examenes.c_RecuperaciónFebrero.Ejercicio02;

import javax.swing.*;

public class Cliente1 {
    private JPanel pnlp;
    public JTextField txfMatricula;
    public JTextField txfKms;
    public JButton btnAceptar;
    private JLabel lblKms;
    private JLabel lblMatricula;
    public JButton btnTerminar;

    public Cliente1(){
        JFrame frame = new JFrame("Cliente");
        frame.setContentPane(pnlp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(300,120);
    }
    public static void main(String[] args) {


        Cliente1 vista = new Cliente1();
        ControladorCliente1 controlador = new ControladorCliente1(vista);

    }
}
