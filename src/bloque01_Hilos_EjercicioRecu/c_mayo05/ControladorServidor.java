package bloque01_Hilos_EjercicioRecu.c_mayo05;

import bloque02_Sockets.Ejercicio03.Persona;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ControladorServidor extends Thread implements ActionListener {

    private VistaServidor vistaServidor;
    private ServerSocket servidor;
    private Socket cliente;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private List<Persona> listaPersonas;

    public ControladorServidor(VistaServidor vistaServidor) {
        this.vistaServidor = vistaServidor;
        listaPersonas = new ArrayList<>();
        addListerns();
        try {
            servidor = new ServerSocket(1234);
            System.out.println("Servidor conectado, esperando clientes...");
            cliente = servidor.accept();
            System.out.println("Cliente conectado " + cliente.getInetAddress());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addListerns() {
        vistaServidor.btnCrear.addActionListener(this);
        vistaServidor.btnMostrar.addActionListener(this);
    }

    @Override
    public void run() {
        try {
            salida = new ObjectOutputStream(cliente.getOutputStream());
            entrada = new ObjectInputStream(cliente.getInputStream());
            int opciones = entrada.readInt();

            escuchador(opciones);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comandos = e.getActionCommand();
        switch (comandos) {
            case "Crear": {
                String nombre = vistaServidor.txfNombre.getText();
                int edad = Integer.parseInt(vistaServidor.txfEdad.getText());
                int opcion = 0;


                crearPersona(nombre, edad);
                System.out.println("Persona creada");

            }
            break;

            case "Mostrar": {
                mostrarPersonas(listaPersonas);
            }
        }
    }

    private void crearPersona(String nombre, int edad) {
        Persona persona = new Persona(nombre, edad);
        listaPersonas.add(persona);
    }

    private void mostrarPersonas(List<Persona> listaPersona) {
        int contador = 0; // Inicializar el contador en 0 en lugar de 1
        for (Persona p : listaPersona) {
            contador++;
            System.out.println(contador + ") " + p.toString());
        }
    }


    private void escuchador(int opcion){

        switch (opcion){
            case 1:{
                enviarLista(listaPersonas);

            }
            break;

            case  2:{
                try {
                    String nombre = entrada.readUTF();
                    System.out.println(nombre);
                    enviarPersona(nombre);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            break;
        }
    }
    private void enviarLista(List<Persona> lista) {
        try {
            salida.writeObject(lista);
            salida.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void enviarPersona(String nombre){

        for(Persona p : listaPersonas){
            if(p.getNombre().equals(nombre)){
                try {
                    salida.writeObject(p);
                    salida.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }
}
