package bloque02_Sockets.Ejercicio04;

import bloque02_Sockets.Ejercicio03.Persona;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor04 {

    public static void main(String[] args) {

        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Daniel",24));
        listaPersonas.add(new Persona("Luis",22));
        listaPersonas.add(new Persona("Oscar",25));
        listaPersonas.add(new Persona("Marcos",25));

        try{
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Esperando conexiones...");
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado " + cliente.getInetAddress());

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());

            salida.writeInt(listaPersonas.size());
            salida.flush();

            int seleccion = 0;

            do{
                seleccion = entrada.readInt();

                if(seleccion >= 0){
                    Persona personaSeleccionada = listaPersonas.get(seleccion);
                    salida.writeObject(personaSeleccionada);
                    salida.flush();
                }

            }while (seleccion >=0);
            salida.close();
            entrada.close();
            cliente.close();
            servidor.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
