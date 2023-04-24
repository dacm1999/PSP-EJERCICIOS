package bloque02_Sockets.Ejercicio01;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente01 {

    public static void main(String[] args) {


        try {
            Socket cliente = new Socket("localhost", 12345);
            System.out.println("Cliente conectado");
            Scanner sc = new Scanner(System.in);

            BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter writer = new PrintWriter(cliente.getOutputStream(), true);

            System.out.println(reader.readLine());
            String mensaje = null;

            do{
                System.out.println("Escribe un mensaje");
                mensaje = sc.nextLine();
                writer.println(mensaje);

            }while (!mensaje.equals("fin"));
            System.out.println("Cliente terminado");
            writer.close();
            reader.close();
            cliente.close();

        } catch (IOException e) {
            System.out.println("ERROR I/O");
        }


    }
}
