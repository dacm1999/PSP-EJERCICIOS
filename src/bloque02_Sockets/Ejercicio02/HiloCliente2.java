package bloque02_Sockets.Ejercicio02;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class HiloCliente2 extends Thread {
    Socket clienteConectado;
    BufferedReader entrada;
    PrintWriter salida;
    String nombreCliente;

    public HiloCliente2(Socket clienteConectado) {
        nombreCliente = "";
        this.clienteConectado = clienteConectado;
        try {
            entrada = new BufferedReader(new InputStreamReader(clienteConectado.getInputStream()));
            salida = new PrintWriter(new OutputStreamWriter(clienteConectado.getOutputStream()), true);
        } catch (IOException e) {
            System.out.println("ERROR I/O");
        }
    }

    @Override
    public void run() {
        try {
            salida.println("Bienvenido: indica tu nombre, por favor: ");
            String nombre = entrada.readLine();
            nombreCliente = nombre;
            String mensaje = "";

            do {
                mensaje = entrada.readLine();
                System.out.println(nombreCliente + " dice " + mensaje);
                salida.println(mensaje);
            } while (!mensaje.equals("fin"));

            System.out.println("Cliente finalizado = " + nombreCliente);
            salida.close();
            entrada.close();
            clienteConectado.close();
        } catch (IOException e) {
            System.out.println("ERROR");
        }

    }
}
