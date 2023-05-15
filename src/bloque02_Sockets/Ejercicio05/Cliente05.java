package bloque02_Sockets.Ejercicio05;

import bloque02_Sockets.Ejercicio03.Persona;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente05 {

    public static void main(String[] args) {

        try {
            Socket cliente = new Socket("localhost", 12345);
            System.out.println("Cliente conectado");

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
            Scanner sc = new Scanner(System.in);

            List<Persona> listaPersonas = new ArrayList<>();
            List<String> listaNombres = (List<String>) entrada.readObject();
            int count = 0;
            String mensajeEnviar = "";


            do {
                for (String p : listaNombres) {
                    count++;
                    System.out.println(count + ") " + p);
                }

                count = 0;
                System.out.println("Escribe el nombre del objeto Persona que deseas recibir, o \"lista\" \npara recibir la lista de personas completa. fin para terminar");

                mensajeEnviar = sc.nextLine();

                if(!mensajeEnviar.equals("fin")){
                    salida.writeUTF(mensajeEnviar);
                    salida.flush();

                    if(mensajeEnviar.equals("lista")){
                        //Recibe una lista de objetos Persona
                        List<Persona> lista = (List<Persona>) entrada.readObject();

                        for(Persona p : lista){
                            System.out.println(p.toString());
                        }
                    } else {
                        //Recibe el objeto persona
                        Persona personaRecibida = (Persona) entrada.readObject();

                        System.out.println("Objeto recibido = " + personaRecibida);
                    }
                }




            } while (!mensajeEnviar.equals("fin"));

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
