package bloque01_Hilos_EjercicioRecu.b_abril12;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ControladorCliente implements ActionListener {
    VistaCliente vistaCliente;
    Socket cliente;
    ObjectOutputStream salida;
    ObjectInputStream entradA;

    public ControladorCliente(VistaCliente vista) {
        this.vistaCliente = vista;
        try {
            cliente = new Socket("localhost", 123);
            System.out.println("Cliente conectado");
            entradA = new ObjectInputStream(cliente.getInputStream());
            salida = new ObjectOutputStream(cliente.getOutputStream());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        addListeners();
    }

    private void addListeners() {
        vistaCliente.btnEnviar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "Enviar": {

                String mensajeEnviar = vistaCliente.txfMensaje.getText();
                String mensajeRecibido = "";
                try {
                    do {
                        salida.writeUTF(mensajeEnviar);
                        salida.flush();

                        mensajeRecibido = entradA.readUTF();
                        String finalMensajeRecibido = mensajeRecibido;
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                vistaCliente.lblRecibido.setText(finalMensajeRecibido);
                            }
                        });

                    } while (cliente.isClosed());


                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
            break;
        }
    }
}
