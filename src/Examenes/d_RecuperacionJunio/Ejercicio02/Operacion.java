package Examenes.d_RecuperacionJunio.Ejercicio02;

import java.io.Serializable;

public class Operacion implements Serializable {

    String ruta;
    String tipo;



    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Operacion(String ruta, String tipo) {
        this.ruta = ruta;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Ruta:" + ruta + " Tipo " + tipo;
    }
}
