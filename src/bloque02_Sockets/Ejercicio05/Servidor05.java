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
            System.out.println("Servidor conectado, esperando clientes...");
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado " + cliente.getInetAddress());

            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

            salida.writeObject(listaNombres);
            salida.flush();

            String seleccion = "";
            do{

                seleccion = entrada.readUTF();


                if(seleccion.equals("lista")){
                    salida.writeObject(listaPersonas);
                    salida.flush();
                }else{
                    for(Persona p: listaPersonas ){

                        if(seleccion.equals(p.getNombre())){
                            salida.writeObject(p);
                            break;
                        }
                    }
                }

                salida.flush();
                System.out.println("Datos enviados");
            }while (!seleccion.equals("fin"));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
