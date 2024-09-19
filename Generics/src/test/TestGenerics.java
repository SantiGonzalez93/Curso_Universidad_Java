package test;

import genericos.ClassGenerics;

public class TestGenerics  {
    public static <T> void main(String[] args) {

        ClassGenerics<Integer> objectInt = new ClassGenerics(15);
        objectInt.obtenerTipo();
        T result = (T) objectInt.getObject();
        System.out.println("result = " + result);


        ClassGenerics<String> objectStr = new ClassGenerics("Santi");
        objectStr.obtenerTipo();
        T result2 = (T) objectStr.getObject();
        System.out.println("result2 = " + result2);
    }
}
