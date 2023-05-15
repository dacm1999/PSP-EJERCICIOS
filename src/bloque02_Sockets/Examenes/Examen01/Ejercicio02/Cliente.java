package bloque02_Sockets.Examenes.Examen01.Ejercicio02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    private JPanel pnlp;
    private JLabel lblNombre;
    private JTextField txfNombre;
    private JLabel lblNota;
    private JTextField txfNota;
    private JButton btnEnviar;

    public Cliente() {
        JFrame frame = new JFrame("Cliente");
        frame.setContentPane(pnlp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        iniciarCliente();

    }

    public void iniciarCliente() {
        try {
            Socket cliente = new Socket("localhost", 12345);
            System.out.println("Cliente conectado");

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());

            btnEnviar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    int objetosRecibidos = 0;
                    float nota = Float.parseFloat(txfNota.getText());
                    String nombre = txfNota.getText();
                    Examen examen = new Examen(nombre, nota);

                    try {
                        salida.writeObject(examen);
                        objetosRecibidos = entrada.readInt();

                        System.out.println(objetosRecibidos);
                        salida.flush();

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        new Cliente();

    }
}
