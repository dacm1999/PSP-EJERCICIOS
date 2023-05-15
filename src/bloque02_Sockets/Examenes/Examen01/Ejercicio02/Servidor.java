package bloque02_Sockets.Examenes.Examen01.Ejercicio02;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private JPanel pnlp;
    private JTextArea txtArea;

    private DefaultListModel<Examen> dlm;

    public Servidor(){
        JFrame frame = new JFrame("Servidor");
        frame.setContentPane(pnlp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(350,350);
        frame.setVisible(true);


        iniciarServidor();

    }

    private void iniciarServidor(){
        try{
            ServerSocket servidor = new ServerSocket(12345);
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado "+cliente.getInetAddress());

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());


            int objetosCreados = 0;
            do{
                Examen examen = (Examen) entrada.readObject();
                int objetosEnviados = entrada.readInt();
                salida.writeInt(objetosEnviados++);
                salida.flush();
                System.out.println(objetosEnviados);
                listarExamenes(examen);

            }while (cliente.isConnected());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void listarExamenes(Examen examen){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                txtArea.append(examen.toString()+"\n");
            }
        });
    }

    public static void main(String[] args) {

        new Servidor();
    }
}
