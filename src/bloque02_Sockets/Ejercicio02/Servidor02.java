package bloque02_Sockets.Ejercicio02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor02 {


    public static void main(String[] args) {

        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor conectado ");
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado " + cliente.getInetAddress());
            HiloCliente2 hiloCliente2 = new HiloCliente2(cliente);
            hiloCliente2.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
