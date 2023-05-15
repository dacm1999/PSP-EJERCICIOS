package bloque02_Sockets.Ejercicio02;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente02 {

    public static void main(String[] args) {

        try {
            Socket cliente = new Socket("localhost", 12345);
            System.out.println("Conexion establecida");
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter writer = new PrintWriter(cliente.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);
            System.out.println(entrada.readLine());

            String mensaje = sc.nextLine();
            writer.println(mensaje);

            do {
                System.out.println("Escribe un mensaje");
                mensaje = sc.nextLine();
                writer.println(mensaje);

            } while (!mensaje.equals("fin"));

            System.out.println("Cliente finalizado");


        } catch (IOException e) {
            System.out.println("ERROR I/O");
        }
    }
}
