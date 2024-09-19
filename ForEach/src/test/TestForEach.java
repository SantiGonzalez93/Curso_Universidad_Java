package test;

public class TestForEach {
    public static void main(String[] args) {
        //foreach es un for mejorado se usa para colecciones listas etc

        int edades[] = {2,3,4,5,6,7,8,9,0};

        //decalaramos una variable del mismo tipo que el array dos puntos y pasamos el array
        for (int edad: edades){
            System.out.println("edad = " + edad);
        }

    }
}




