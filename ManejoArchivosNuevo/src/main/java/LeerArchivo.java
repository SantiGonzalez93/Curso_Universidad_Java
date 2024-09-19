import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeerArchivo {
    public static void main(String[] args) {
        String fileName = "mi_archivo.txt";
        File file = new File(fileName);

        try {
            System.out.println("file content");
            //open file
            BufferedReader entry = new BufferedReader(new FileReader(file));
            //reading line by line
            String line = entry.readLine();
            while (line != null) {
                System.out.println(line);
                line = entry.readLine();

            }
            entry.close();
        } catch (Exception e) {
            System.out.println("error reading file");

        }
    }
}