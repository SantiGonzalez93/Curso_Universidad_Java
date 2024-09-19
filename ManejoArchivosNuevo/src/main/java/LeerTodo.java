import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LeerTodo {
    public static void main(String[] args) {

        String fileName = "mi_archivo.txt";
        try{
            //reading all lines at once.
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            System.out.println("file content, all at once");
            lines.forEach(line -> {
                System.out.println(line);
            });
        }catch (Exception e ){
            System.out.println("error reading file " + e);
        }
    }
}
