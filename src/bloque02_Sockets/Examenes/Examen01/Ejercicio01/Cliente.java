package bloque02_Sockets.Examenes.Examen01.Ejercicio01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {


        try{
            Socket cliente = new Socket("localhost",12345);

            Scanner sc = new Scanner(System.in);
            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());


            String palabraAdivinar ="";
            String respuesta = "";
            int numLetras = entrada.readInt();
            System.out.println("La palabra tiene un total de " + numLetras + " letras");
            do{
                System.out.println("Escribe la palabra");
                palabraAdivinar = sc.next();
                salida.writeUTF(palabraAdivinar);
                salida.flush();

                respuesta = entrada.readUTF();
                System.out.println(respuesta);

            }while (!respuesta.equals("acertaste") && !respuesta.equals("perdiste"));

            sc.close();
            cliente.close();
            salida.close();
            entrada.close();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
