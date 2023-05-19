package Examenes.c_RecuperaciónFebrero.Ejercicio01;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                Ejercicio01 vista = new Ejercicio01();
                Controlador controlador = new Controlador(vista);

            }
        });

    }
}
