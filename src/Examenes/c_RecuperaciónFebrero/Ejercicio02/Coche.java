package Examenes.c_RecuperaciónFebrero.Ejercicio02;

import java.io.Serializable;

public class Coche implements Serializable {

    private String matricula;
    private int kms;

    public Coche(String matricula, int kms) {
        this.matricula = matricula;
        this.kms = kms;
    }

    @Override
    public String toString() {
        return "Matricula " + matricula + " KMS " + kms;
    }
}
