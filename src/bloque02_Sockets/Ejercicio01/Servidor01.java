package bloque02_Sockets.Ejercicio01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor01 {

    public static void main(String[] args) {


        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor conectado");
            do{
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado " + cliente.getInetAddress());
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                PrintWriter salida = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()),true);

                salida.println("Bienvenido");

                String mensaje = null;

                do{
                    mensaje = entrada.readLine();
                    System.out.println("Cliente: " + mensaje);
                }while (!mensaje.equals("fin"));
                salida.close();
                entrada.close();
                cliente.close();
            }while(!servidor.isClosed());
            System.out.println("Servidor desconectado ");
            servidor.close();
        } catch (IOException e) {
            System.out.println("ERROR I/O");
        }

    }
}
