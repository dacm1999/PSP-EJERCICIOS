package Examenes.c_RecuperaciónFebrero.Ejercicio02.Solucion;

import Examenes.c_RecuperaciónFebrero.Ejercicio02.Coche;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private JList<Coche> list1;
    private static DefaultListModel<Coche> dlm;

    public static void main(String[] args) {


        try {
            System.out.println("Esperando clientes...");
            ServerSocket servidor = new ServerSocket(12345);
            //Cliente1
            Socket cliente1 = servidor.accept();
            System.out.println("Cliente1 conectado" + cliente1.getInetAddress());
            //FLUJO DE DATOS CLIENTE1
            ObjectInputStream entradaSocket = new ObjectInputStream(cliente1.getInputStream());



            Socket cliente2 = servidor.accept();
            System.out.println("Cliente2 conectado" + cliente1.getInetAddress());
            ObjectOutputStream salidaSocket = new ObjectOutputStream(cliente2.getOutputStream());

            String respuesta = "";
            do {
                Coche coche = (Coche) entradaSocket.readObject();
                System.out.println("Objeto recibido");
                salidaSocket.writeObject(coche);
                salidaSocket.flush();
                System.out.println("ObjetoEnviado");
            } while (!respuesta.equals("terminar"));
            servidor.close();
            cliente1.close();
            cliente2.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException e) {
            System.out.println("");
        }

    }

    /*
    private static void listarObjetos(Coche coche) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                dlm.addElement(coche);
            }
        });
    }

     */

}
