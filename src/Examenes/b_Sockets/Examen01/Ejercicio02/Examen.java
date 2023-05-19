package Examenes.b_Sockets.Examen01.Ejercicio02;

import java.io.Serializable;

public class Examen  implements Serializable {

    private String nombre;
    private float nota;

    public Examen(String nombre, float nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nombre " + nombre + " Nota " + nota;
    }
}
