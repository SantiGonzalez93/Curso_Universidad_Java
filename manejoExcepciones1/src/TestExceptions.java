import aritmetica.Artitmetica;

public class TestExceptions {

    public static void main(String[] args) {

        int result = 0;


        try {
            result = Artitmetica.division(10, 0);

        }catch (Exception e){
            e.printStackTrace(System.out);
        }
        System.out.println("result = " + result);


    }
}
