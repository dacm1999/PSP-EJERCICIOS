package bloque02_Sockets.Ejercicio02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor02 {


    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(12345);
            do{
                System.out.println("Esperando clientes...");
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado " + cliente.getInetAddress());
                HiloCliente2 hiloCliente2 = new HiloCliente2(cliente);
                hiloCliente2.start();

            }while (!servidor.isClosed());
            System.out.println("SERVIDOR TERMINADO");

        } catch (IOException e) {
            System.out.println("ERROR I/O");
        }
    }
}
