package bloque02_Sockets.Ejercicio02;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente02 {

    public static void main(String[] args) {


        try {
            Socket cliente = new Socket("localhost", 12345);
            System.out.println("Cliente conectado");
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
            Scanner sc = new Scanner(System.in);



            //me pide el nombre
            System.out.println(entrada.readUTF());
            String nombre = sc.nextLine();
            salida.writeUTF(nombre);
            salida.flush();


            String mensaje = "";
            do {
                System.out.println("Introduce un mensaje ");
                mensaje = sc.nextLine();

                salida.writeUTF(mensaje);
                salida.flush();


            } while (!mensaje.equals("fin"));


            salida.close();
            entrada.close();
            sc.close();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
