package bloque01_Hilos.Ejercicio06;

import bloque01_Hilos.Ejercicio05.Temporizador5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    private Ejercicio06 vista;

    public Controlador(Ejercicio06 vista) {
        this.vista = vista;
        addListeners();
    }

    private  void addListeners(){
        vista.btnIniciar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        switch (comando){
            case "Iniciar":{
                int tiempo = Integer.parseInt(vista.txfTiempo.getText());
                System.out.println(tiempo);
                Temporizador5 temp = new Temporizador5(tiempo);
                temp.start();
            }
        }

    }
}
