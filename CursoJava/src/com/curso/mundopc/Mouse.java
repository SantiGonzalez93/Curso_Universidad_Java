package com.curso.mundopc;

public class Mouse extends DispositivoEntrada{

    private final int idMouse;
    private static int contadorMouse;

    public Mouse (String tipoEntrada, String marca){
        super(tipoEntrada,marca);
        this.idMouse = ++Mouse.contadorMouse;

    }

    @Override
    public String toString() {
        return "Mouse{" +
                "idMouse=" + idMouse +
                ", tipoEntrada='" + tipoEntrada + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
