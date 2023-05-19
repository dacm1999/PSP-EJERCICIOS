package Examenes.c_RecuperaciónFebrero.Ejercicio01;

import javax.swing.*;

public class Ejercicio01 {


    private JPanel pnp;
    public JTextField txfRuta;
    public JButton btnAceptar;
    public JButton btnPausar;
    public JButton btnDetener;
    public JTextArea txtLista;


    public Ejercicio01(){
        JFrame frame = new JFrame("Ejercicio01");
        frame.setContentPane(pnp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(350,350);
    }
}
