package Examenes.b_Sockets.Examen01.Ejercicio01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la palabra secreta");
        String palabraSecreta = sc.next();

        try{
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Esperando clientes...");

            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado" + cliente.getInetAddress());

            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

            salida.writeInt(palabraSecreta.length());
            salida.flush();

            String palabraRecibida = "";
            do{
                palabraRecibida = entrada.readUTF();

                if(palabraRecibida.equals(palabraSecreta)){
                    salida.writeUTF("acertaste");
                    salida.flush();
                }else{
                    salida.writeUTF("fallaste");
                    salida.flush();
                }

            }while (!palabraSecreta.equals(palabraRecibida));

            salida.close();
            entrada.close();
            cliente.close();
            servidor.close();







        } catch (IOException e) {
            System.out.println("ERROR I/O");
        }

    }
}
