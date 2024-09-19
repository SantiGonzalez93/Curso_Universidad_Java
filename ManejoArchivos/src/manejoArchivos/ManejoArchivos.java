package manejoArchivos;

import java.io.*;

public class ManejoArchivos {

    public static void crearArchivo(String nombreArchivo){

        //Creo un Objeto del tipo File
        File archivo = new File(nombreArchivo);

        //Creo un objeto del tipo PrintWriter, pero hay que manejar el error en caso de que no se pueda crear
        try {
            //el archivo se crea en memoria en este punto
            PrintWriter salida = new PrintWriter(archivo);
            //cierro el archivo y es el momento donde se crea en disco
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    /* public static void escribirArchivo(String nombreArchivo, String contenidoArchivo){

        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(contenidoArchivo);
            salida.close();
            System.out.println("Se ha escrito el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    } */

    //este metodo a diferencia del anterior que esta comentado, lo que hace es no pisar la escritura,
    // sino que va anexando al final todo lo que se le vaya pasando
    public static void escribirArchivo(String nombreArchivo, String contenidoArchivo){

        File archivo = new File(nombreArchivo);
        try {
            //Nota: al pasar FlieWriter como parametro, lo que hacemos es anexar al arhivo
            // con el segundo parametro, ya que lo configuramos en TRUE
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(contenidoArchivo);
            salida.close();
            System.out.println("Se ha anexado informacion al archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void leerArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            //Nota: si la primera linea estuviera vacía, entonces no entraria al bucle, pudiendo las siguientes
            // terner información, a modo de ejemplo sirve pero no es robusto.
            String lectura = entrada.readLine();
            while (lectura != null){
                System.out.println("lectura = " + lectura);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
           e.printStackTrace(System.out);
        } catch (IOException e) {
           e.printStackTrace(System.out);
        }

    }

}
