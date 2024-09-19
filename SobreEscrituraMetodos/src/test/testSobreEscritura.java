package test;

import domain.*;

public class testSobreEscritura {
    public static void main(String[] args) {

        Gerente gerente1 = new Gerente("Santi ", 5000, "Godoy Cruz");
        System.out.println(gerente1.obtenerDetalles());
        
    }
}
