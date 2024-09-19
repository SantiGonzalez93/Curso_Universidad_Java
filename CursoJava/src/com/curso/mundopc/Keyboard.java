package com.curso.mundopc;

public class Keyboard extends DispositivoEntrada{

    private final int idKeyboard;
    private static int contadorKeyboard;

    public Keyboard (String tipoEntrada, String marca){
        super (tipoEntrada,marca);
        this.idKeyboard = ++Keyboard.contadorKeyboard;
    }

    @Override
    public String toString() {
        return "Keyboard{" +
                "idKeyboard=" + idKeyboard +
                ", tipoEntrada='" + tipoEntrada + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
