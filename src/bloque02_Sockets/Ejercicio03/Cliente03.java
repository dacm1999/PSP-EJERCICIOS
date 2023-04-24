package bloque02_Sockets.Ejercicio03;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

public class Cliente03 {

    public static void main(String[] args) {

        try {
            Socket cliente = new Socket("localhost", 12345);
            System.out.println("Conexion establecida");

            ObjectInputStream entrada = new ObjectInputStream(new DataInputStream(cliente.getInputStream()));

            List<Persona> listaPersonas = (List<Persona>) entrada.readObject();

            System.out.println("Personas");
            int contador = 0;
            for(Persona persona : listaPersonas){
                contador++;
                System.out.println(contador + " " + persona.toString());
            }




        } catch (IOException e) {
            System.out.println("ERROR I/O");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }

    }
}
