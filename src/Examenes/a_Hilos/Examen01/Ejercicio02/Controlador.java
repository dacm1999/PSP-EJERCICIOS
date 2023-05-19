package Examenes.a_Hilos.Examen01.Ejercicio02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class Controlador implements ActionListener {

    private Ejercicio02 vista;

    public Controlador(Ejercicio02 vista) {
        this.vista = vista;
        addListeners();
    }

    public void addListeners(){
        vista.btnActivar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comandos = e.getActionCommand();

        switch (comandos){
            case "Iniciar": {
                System.out.println("Hola");

                LocalTime time= LocalTime.now();

                System.out.println(time.getHour() + ":" + time.getMinute());


            }
            break;
        }

    }
}
