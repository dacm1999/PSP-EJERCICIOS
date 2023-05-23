package bloque01_Hilos_EjercicioRecu.a_marzo23;

import javax.swing.*;

public class Ejercicio01 {
    private JPanel pnlp;
    public  JButton aceptarButton;
    public JLabel lbl1;
    public JTextField txfTiempo;
    public JLabel lbl2;


    public Ejercicio01() {
        JFrame frame = new JFrame("Ejercicio01");
        frame.setContentPane(pnlp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        Ejercicio01 ejercicio01 = new Ejercicio01();
        Controlador controlador = new Controlador(ejercicio01);


    }
}
