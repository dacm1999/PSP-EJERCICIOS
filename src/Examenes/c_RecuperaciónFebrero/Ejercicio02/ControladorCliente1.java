package Examenes.c_RecuperaciónFebrero.Ejercicio02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ControladorCliente1 implements ActionListener {

    private Cliente1 vista;

    private Socket cliente;
    private ObjectOutputStream salida;
    private PrintWriter writer;

    public ControladorCliente1(Cliente1 vista) {
        this.vista = vista;
        addListeners();

        try {
            cliente = new Socket("localhost",1234);
            salida = new ObjectOutputStream(new DataOutputStream(cliente.getOutputStream()));
            writer = new PrintWriter(cliente.getOutputStream());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void addListeners(){
        vista.btnAceptar.addActionListener(this);
        vista.btnTerminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comandos = e.getActionCommand();

        switch (comandos){

            case "Aceptar":{

                try{

                    String matricula = vista.txfMatricula.getText();
                    int kms = Integer.parseInt(vista.txfKms.getText());

                    Coche coche = new Coche(matricula,kms);

                    salida.writeObject(coche);
                    salida.flush();


                    cliente.close();
                    salida.close();

                } catch (UnknownHostException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
            break;

            case "Terminar": {
                String mensaje = "terminar";
                writer.println(mensaje);
                System.exit(0);
            }
            break;

        }
    }
}
