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


        List <String> nombrePersona = new ArrayList<>();


        try {
            Socket cliente = new Socket("localhost",12345);
            System.out.println("Cliente conectado ");

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
            Scanner sc = new Scanner(System.in);

            List<String> listaNombres;

            String seleccion = "";
            do{

                listaNombres = (List<String>) entrada.readObject();

                int contador = 0;
                for(String n : listaNombres){
                    contador++;
                    System.out.println(contador + " " + n);
                }
                System.out.println("Escribe el nombre de una persona: ");
                seleccion = sc.nextLine();
                salida.writeUTF(seleccion);

                if(seleccion.equals("lista")){
                    List<Persona> lista = (List<Persona>) entrada.readObject();
                    for(Persona p : lista){
                        System.out.println(p.toString());
                    }
                }else{
                    Persona personaRecibida = (Persona) entrada.readObject();
                    System.out.println(personaRecibida.toString());
                }

            }while (!seleccion.equals("fin"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
