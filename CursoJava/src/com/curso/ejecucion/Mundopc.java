package com.curso.ejecucion;

import com.curso.mundopc. *;

public class Mundopc {
    public static void main(String[] args) {

        Monitor monitorHP = new Monitor("HP", 13);
        Keyboard keyboardHP = new Keyboard("bluetooth", "HP");
        Mouse mouseHP = new Mouse("Cable", "HP");

        Computadora computadoraHP = new Computadora("computadoraHP", monitorHP, keyboardHP, mouseHP);


        Monitor monitorGamer = new Monitor("Gamer", 24);
        Keyboard keyboardGamer = new Keyboard("bluetooth", "Gamer");
        Mouse mouseGamer = new Mouse("Cable", "Gamer");

        Computadora computadoraGamer = new Computadora("computadoraGamer", monitorGamer, keyboardGamer, mouseGamer);

        Orden orden1 = new Orden();
        orden1.agregarComputadora(computadoraGamer);
        orden1.agregarComputadora(computadoraHP);

        orden1.mostrarOrden();


    }
}
