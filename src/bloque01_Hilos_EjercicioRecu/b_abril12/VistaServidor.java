package bloque01_Hilos_EjercicioRecu.b_abril12;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class VistaServidor {
    private JPanel pnpL;
    public JLabel lblMensajeRecibido;

    public VistaServidor() throws IOException {
        JFrame frame = new JFrame("VistaServidor");
        frame.setContentPane(pnpL);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300,100);
        frame.setLocationRelativeTo(null);


        ServerSocket servidor = new ServerSocket(123);
        System.out.println("Servidor conectado, esperando clientes...");
        Socket cliente = servidor.accept();
        System.out.println("Cliente conectado " + cliente.getInetAddress());
        ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

        String mensaje = "";

        do{
            mensaje = entrada.readUTF();
            if(!mensaje.equals(" ")){
                String finalMensaje = mensaje;
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        lblMensajeRecibido.setText(finalMensaje);
                    }
                });

                String mensajeEnviar = "MensajeRecibido";
                salida.writeUTF(mensajeEnviar);
                salida.flush();
                System.out.println("Mensaje enviado");
            }else if(mensaje.equals("fin")){
                System.exit(0);
            }

        }while (servidor.isClosed());

    }

    public static void main(String[] args) {
        try {
            VistaServidor vista = new VistaServidor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
