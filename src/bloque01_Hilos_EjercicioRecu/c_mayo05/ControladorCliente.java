package bloque01_Hilos_EjercicioRecu.c_mayo05;

import bloque02_Sockets.Ejercicio03.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ControladorCliente implements ActionListener {

    private VistaCliente vista;
    private Socket cliente;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private List<Persona> listaPersona;
    private int opcion;

    public ControladorCliente(VistaCliente vista) {
        this.vista = vista;
        addListeners();
        try {
            cliente = new Socket("localhost", 1234);
            System.out.println("Cliente conectado...");
            entrada = new ObjectInputStream(cliente.getInputStream());
            salida = new ObjectOutputStream(cliente.getOutputStream());
            listaPersona = new ArrayList<>();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void addListeners(){
        vista.btnLista.addActionListener(this);
        vista.btnPersona.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando){
            case "Persona":{
                opcion = 2;
                try {
                    salida.writeInt(opcion);
                    salida.flush();
                    String nombre = vista.txfNombre.getText();
                    salida.writeUTF(nombre);
                    salida.flush();

                    Persona p = (Persona) entrada.readObject();
                    actualizarPersona(p);

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }


            }
            break;

            case "Lista":{

                try {
                    opcion = 1;
                    salida.writeInt(opcion);
                    salida.flush();

                    listaPersona = (List<Persona>) entrada.readObject();
                    actualizarLista(listaPersona);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
            break;
        }
    }

    private void actualizarLista(List<Persona> lista){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                for(Persona p : lista){
                    vista.txtArea.setText("");
                    vista.txtArea.append(p.toString() + "\n");
                }
            }
        });
    }

    private void actualizarPersona(Persona p){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                vista.txtArea.setText("");
                vista.txtArea.append(p.toString() +"\n");
            }
        });
    }
}
