package Examenes.d_RecuperacionJunio.Ejercicio02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ControladorCliente implements ActionListener {

    private VistaCliente vista;

    private Socket cliente;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;

    private String tipo;
    private String ruta;
    private String terminar;


    public ControladorCliente(VistaCliente vista) {
        this.vista = vista;
        addListenters();

        try {
            cliente = new Socket("localhost", 123);
            System.out.println("Cliente conectado ");
            entrada = new ObjectInputStream(cliente.getInputStream());
            salida = new ObjectOutputStream(cliente.getOutputStream());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addListenters() {
        vista.btnAceptar.addActionListener(this);
        vista.btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {

            case "Aceptar": {

                String terminar = "";
                String ruta = vista.txfRuta.getText();
                String tipo = vista.txfTipo.getText();
                String mensaje = "";
                try {
                    Operacion operacion = new Operacion(ruta, tipo);
                    salida.writeObject(operacion);
                    salida.flush();
                    System.out.println("Objeto enviado");

                    mensaje = entrada.readUTF();
                    String finalMensaje = mensaje;
                    vista.lblRecibido.setText(finalMensaje);

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
            break;

            case "Salir": {
                try {
                    System.out.println("Cliente finalizado");
                    terminar = "fin";
                    cliente.close();
                    entrada.close();
                    salida.close();
                    System.exit(0);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("hol");

            }
            break;
        }

    }
}
