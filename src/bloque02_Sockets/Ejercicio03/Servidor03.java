package bloque02_Sockets.Ejercicio03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor03  {

    public static void main(String[] args) {

        List<Persona> listaPersonas = new ArrayList<>();

        listaPersonas.add(new Persona("Daniel",24));
        listaPersonas.add(new Persona("Luis",22));
        listaPersonas.add(new Persona("Oscar",25));
        listaPersonas.add(new Persona("Oscar",25));


        try{
            System.out.println("Esperando conexion...");
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Conexion establecida.");
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado " + cliente.getInetAddress());

            ObjectOutputStream salida = new ObjectOutputStream(new DataOutputStream(cliente.getOutputStream()));

            salida.writeObject(listaPersonas);
            salida.flush();
            System.out.println("Objeto enviado");

            salida.close();
            cliente.close();
            servidor.close();

        } catch (IOException e) {
            System.out.println("ERROR I/O");
        }


    }
}
