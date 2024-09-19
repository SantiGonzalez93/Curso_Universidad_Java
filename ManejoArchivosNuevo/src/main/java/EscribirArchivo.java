import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class EscribirArchivo {
    public static void main(String[] args) {
        boolean anexar = false;
        String nombreArchivo = "mi_archivo.txt";
        File archivo = new File(nombreArchivo);
        try{
            //ver si existe el archivo
            anexar = archivo.exists();
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            String nuevoContenido = "Nuevo\ncontendido";
            salida.println(nuevoContenido);
            salida.close();
        }catch (Exception e) {

        }
    }
}
