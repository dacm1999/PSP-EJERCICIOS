package bloque02_Sockets.Ejercicio04;

import bloque02_Sockets.Ejercicio03.Persona;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente04 {

    public static void main(String[] args) {

        System.out.println("Estableciendo conexion");
        try {
            Socket cliente = new Socket("localhost", 1597);
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
            System.out.println("Conexion establecida");
            Scanner sc = new Scanner(System.in);

            int numPersonas = entrada.readInt();
            int seleccion = 0;
            do {

                System.out.println("Hay un total de " + numPersonas + " personas");
                System.out.println("Escoge de 0 a " + (numPersonas-1));
                seleccion = sc.nextInt();

                if(seleccion >= 0 || seleccion > numPersonas -1){
                    salida.writeInt(seleccion);
                    salida.flush();

                    Persona personaRecibida = (Persona) entrada.readObject();
                    System.out.println("La persona seleccionada es: " +"\n" + personaRecibida.toString());
                }else{
                    System.out.println(entrada.readUTF());
                }
            } while (seleccion >= 0);
            salida.close();
            entrada.close();
            cliente.close();

        } catch (IOException e) {
            System.out.println("ERROR I/O");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }


    }
}
