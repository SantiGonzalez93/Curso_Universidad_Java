package test;

import static manejoArchivos.ManejoArchivos.*;

public class TestManejoArchivos {
    public static void main(String[] args) {

        //en el nombre del Archivo uso la ruta completa, la primera barra es para escapar la segunda(windows)
        //Si estamos en linux o mac "~/carpeta/carpeta/Prueba.txt"
        String nombreArchivo = "C:\\Users\\sgonzalez\\Desktop\\desencriptar\\Prueba.txt";

        //crearArchivo(nombreArchivo);

        escribirArchivo(nombreArchivo, "Primera escritura");
        escribirArchivo(nombreArchivo, "Segunda escritura");
        escribirArchivo(nombreArchivo, "Tercera escritura");

        leerArchivo(nombreArchivo);

    }
}
