package Examenes.c_RecuperaciónFebrero.Ejercicio02.Solucion;


import Examenes.c_RecuperaciónFebrero.Ejercicio02.Coche;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Cliente2 {
    private JPanel pnlP;
    private JTextArea txtObjetos;

    public Cliente2(){
        try {
            Socket cliente2 = new Socket("localhost", 12345);
            System.out.println("Cliente2 conectado");

            ObjectInputStream entradaSocket = new ObjectInputStream(new DataInputStream(cliente2.getInputStream()));

            do{
                Coche coche = (Coche) entradaSocket.readObject();
                txtObjetos.append(coche.toString());
                System.out.println(coche.toString());
            }while(!cliente2.isConnected());

        } catch (IOException e) {
            System.out.println();
        } catch (ClassNotFoundException e) {
            System.out.println("clase no encontrada");
        }

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cliente2");
        frame.setContentPane(new Cliente2().pnlP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(400,400);
    }
}
