package bloque02_Sockets.Ejercicio05;

import bloque02_Sockets.Ejercicio03.Persona;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor05 {

    public static void main(String[] args) {


        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Daniel",24));
        listaPersonas.add(new Persona("Luis",22));
        listaPersonas.add(new Persona("Oscar",25));
        listaPersonas.add(new Persona("Marcos",25));
        List<String> listaNombres = new ArrayList<>();


        for(Persona p : listaPersonas){
            listaNombres.add(p.getNombre());
        }

        try{
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Esperando conexiones...");
            Socket cliente = servidor.accept();
            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            System.out.println("Conectado");
            salida.writeObject(listaNombres);
            salida.flush();


            String mensajeRecibido = "";
            do{
                System.out.println(mensajeRecibido = entrada.readUTF());


                if (mensajeRecibido.equals("lista")) {
                    //Envio la lista de Persona
                    salida.writeObject(listaPersonas);
                } else {
                    //Busco el objeto seleccionado y lo envio
                    for (Persona persona : listaPersonas) {
                        if (persona.getNombre().equals(mensajeRecibido)) {
                            salida.writeObject(persona);
                            break;
                        }
                    }
                }
                salida.flush();
                System.out.println("Datos enviados");

            }while (!mensajeRecibido.equals("fin"));




        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
