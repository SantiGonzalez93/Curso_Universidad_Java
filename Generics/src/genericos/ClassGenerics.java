package genericos;

public class ClassGenerics <T> {

    T object;

    public ClassGenerics(T object){
        this.object = object;
    }

    public void obtenerTipo(){
        System.out.println("el tipo T es: " + object.getClass().getSimpleName() );
    }

    public T getObject(){
        return this.object;
    }
}
