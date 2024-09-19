package test;

import java.util.*;

import java.util.ArrayList;

public class TestCollections {
    public static void main(String[] args) {

        // La interfaz List es implementada con ArrayList

        List miLista = new ArrayList();

        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("jueves");
        miLista.add("Viernes");

        imprimir(miLista);


        //asignamos la clase Hashset (que implementa Set) a un tipo Interfaz Set que hereda de collection
        Set miSet = new HashSet();

        miSet.add("lunes");
        miSet.add("martes");
        miSet.add("mieroles");
        miSet.add("jueves");
        miSet.add("viernes");
        miSet.add("viernes");

        imprimir(miSet);

        // Trabajando con Map, HashMap clase que implementa la interfaz Map

        Map miMapa = new HashMap();

        miMapa.put("Día1" , "Lunes");
        miMapa.put("Día2" , "Martes");
        miMapa.put("Día3" , "Miercoles");
        miMapa.put("Día4" , "Jueves");
        miMapa.put("Día5" , "Viernes");

        //el metodó get, recibe la key como argumento, y devuelve el value de la misma
        String element= (String) miMapa.get("Día1");
        System.out.println("element = " + element);
        System.out.println("");
        //estamos imprimiendo las llaves
        imprimir(miMapa.keySet());

        //estamos imprimendo los values
        imprimir(miMapa.values());




        
    }
    
    public static void imprimir (Collection collection){
        
        collection.forEach(elemtens ->{
            System.out.println("elemtens = " + elemtens);
        });
        System.out.println("");
    }

}
