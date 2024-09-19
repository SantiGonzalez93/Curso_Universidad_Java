package aritmetica;

import exceptions.OperationException;

public class Artitmetica {

    public static int division(int numerador, int denominador) throws OperationException{
        if (denominador == 0){
            throw new OperationException("division entre cero");
        }
        return numerador/denominador;
    }
}
