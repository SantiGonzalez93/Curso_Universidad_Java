package testCollectionsGenerics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

public class TestCollectionsGenerics {
    public static void main(String[] args) {

        List<String> miList = new ArrayList<>();

        miList.add("Lunes");
        miList.add("Martes");
        miList.add("Miercoles");
        miList.add("Jueves");
        miList.add("Viernes");


        //Declarando un Set con Generics
        Set<String> miSet = new HashSet<>();
        //Declarando un Map con Generics
        Map<String , String> miMap = new HashMap<>();

    }
    public void imprimir (Collection collection){
        
        collection.forEach(element -> {
            System.out.println("element = " + element);
        });
        System.out.println("");
        
    }
}
