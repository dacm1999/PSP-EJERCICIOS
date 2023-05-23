package bloque02_Sockets.Ejercicio02;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class HiloCliente2 extends Thread {
    Socket clienteConectado;
    ObjectInputStream entrada;
    ObjectOutputStream salida;
    String nombreCliente;

    public HiloCliente2(Socket clienteConectado) {
        nombreCliente = "";
        this.clienteConectado = clienteConectado;
        try {
            salida = new ObjectOutputStream(clienteConectado.getOutputStream());
            entrada = new ObjectInputStream(clienteConectado.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {

        try {
            salida.writeUTF("Indica tu nombre por favor: ");
            salida.flush();
            String nombre = entrada.readUTF();
            nombreCliente = nombre;
            String mensaje = "";
            do{

                mensaje = entrada.readUTF();
                System.out.println(nombreCliente + " dice " + mensaje);
                salida.writeUTF(mensaje);
                salida.flush();
            }while (!mensaje.equals("fin"));


            salida.close();
            entrada.close();
            clienteConectado.close();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
