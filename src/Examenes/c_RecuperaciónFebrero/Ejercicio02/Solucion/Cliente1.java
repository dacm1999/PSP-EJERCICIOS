package Examenes.c_RecuperaciónFebrero.Ejercicio02.Solucion;


import Examenes.c_RecuperaciónFebrero.Ejercicio02.Coche;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Cliente1 {
    private JPanel pnlP;
    private JTextField txfMatricula;
    private JTextField txfKms;
    private JLabel lbl2;
    private JLabel lbl1;
    private JButton btnEnviar;
    private JButton btnTerminar;


    public Cliente1(){
        try {
            //creo el socket
            Socket cliente1 = new Socket("localhost", 12345);
            System.out.println("Cliente conectado");


            //Creo el flujo de datos
            ObjectOutputStream salidaSocket = new ObjectOutputStream(new DataOutputStream(cliente1.getOutputStream()));
            PrintWriter writer = new PrintWriter(cliente1.getOutputStream());
//            String matricula = txfMatricula.getText();
//            String kms = txfKms.getText();
//            Coche coche1 = new Coche(matricula, kms);
            btnEnviar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String matricula = txfMatricula.getText();
                        int kms = Integer.parseInt(txfKms.getText());
                        Coche coche1 = new Coche(matricula, kms);
                        salidaSocket.writeObject(coche1);
                        salidaSocket.flush();
                    } catch (IOException ex) {
                        System.out.println("error");
                    }
                }
            });

            btnTerminar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String mensaje= "terminar";
                    writer.println(mensaje);
                    System.exit(0);
                }
            });

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Cliente1");
        frame.setContentPane(new Cliente1().pnlP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(350,350);

    }
}
