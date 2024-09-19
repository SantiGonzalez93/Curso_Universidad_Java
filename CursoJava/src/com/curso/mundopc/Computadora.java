package com.curso.mundopc;



public class Computadora {

    private final int idComputadora;
    private String nombre;
    private Monitor monitor;
    private Keyboard keyboard;
    private Mouse mouse;
    private static int contadorComputadora;

    private Computadora (){

        this.idComputadora = ++Computadora.contadorComputadora;
    }

    public Computadora (String nombre, Monitor monitor, Keyboard keyboard, Mouse mouse){
        this();
        this.nombre = nombre;
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public int getIdComputadora() {
        return idComputadora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Mouse getMouse() {
        return this.mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    @Override
    public String toString() {
        return "Computadora{" +
                "idComputadora=" + idComputadora +
                ", nombre='" + nombre + '\'' +
                ", monitor=" + monitor +
                ", keyboard=" + keyboard +
                ", mouse=" + mouse +
                '}';
    }
}
