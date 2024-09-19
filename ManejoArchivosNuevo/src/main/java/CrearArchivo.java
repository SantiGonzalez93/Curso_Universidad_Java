import java.io.File;
import java.io.FileWriter; //input output
import java.io.PrintWriter;

public class CrearArchivo {
    public static void main(String[] args) {
        String fileName = "mi_archivo.txt";
        File file = new File(fileName);

        try {
            PrintWriter exit = new PrintWriter(new FileWriter(file));
            exit.close();
            System.out.println("the file has been created successfully");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e);
            e.printStackTrace();
        }
    }
}
