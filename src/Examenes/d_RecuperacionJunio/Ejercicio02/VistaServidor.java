package Examenes.d_RecuperacionJunio.Ejercicio02;

import com.sun.security.ntlm.Server;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class VistaServidor {
    private JPanel pnpL;
    public JTextArea txtArea;



    public VistaServidor() {
        JFrame frame = new JFrame("Servidor");
        frame.setContentPane(pnpL);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400,200);
        frame.setLocationRelativeTo(null);

        try {
            ServerSocket servidor = new ServerSocket(123);
            System.out.println("Servidor conectado, esperando clientes...");
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado");
            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

            System.out.println("Estoy aqui");
            do{
                Operacion operacion= (Operacion) entrada.readObject();
                System.out.println("Objeto recibido");
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        txtArea.append("Objeto recibido"+"\n");
                    }
                });
                String ruta = operacion.getRuta();
                String tipo = operacion.getTipo();
                salida.flush();
                if(tipo.equals("Crear")){
                    File file = new File(ruta);
                    file.createNewFile();
                    salida.writeUTF("Fichero creado");
                    salida.flush();
                    System.out.println("Fichero creado");
                } else if (tipo.equals("Borrar")) {
                    File file = new File(ruta);
                    if(file.exists()){
                        file.delete();
                        salida.writeUTF("Fichero eliminado");
                        salida.flush();
                        System.out.println("Fichero eliminado");

                    }
                }


            }while (!cliente.isClosed());

        } catch (IOException e) {
            System.out.println("Cliente desconectado");
            System.out.println("Servidor desconectado");
            System.exit(0);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        VistaServidor vista = new VistaServidor();

    }
}
