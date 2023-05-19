package Examenes.c_RecuperaciónFebrero.Ejercicio02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {

        try{
            System.out.println("Esperando clientes...");
            ServerSocket servidor = new ServerSocket(1234);

            Socket cliente1 = servidor.accept();
            System.out.println("Cliente 1 conectado");
            ObjectInputStream entradaSocket1 = new ObjectInputStream(cliente1.getInputStream());


            Socket cliente2 = servidor.accept();
            System.out.println("Cliente 2 conectado");
            ObjectOutputStream salidaSocket = new ObjectOutputStream(cliente2.getOutputStream());

            String respuesta = "";
            do {
                Coche coche = (Coche) entradaSocket1.readObject();
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
        }
    }
}
