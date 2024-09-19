package com.curso.mundopc;

public class Monitor {
    private final int idMonitor;
    private String marca;
    private double size;
    private static int contadorMonitor;

    //constructores
    private Monitor (){
        this.idMonitor = ++Monitor.contadorMonitor;
    }
    public Monitor (String marca, double size){
        this();
        this.marca = marca;
        this.size = size;
    }

    //getters and setters

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getIdMonitor() {
        return this.idMonitor;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "idMonitor=" + idMonitor +
                ", marca='" + marca + '\'' +
                ", size=" + size +
                '}';
    }
}
