package mx.com.gm.peliculas.domain;

public class Pelicula {

    private String nombre;

    public Pelicula(){
    }

    public Pelicula (String nombre){
        this.nombre = nombre;
    }
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    public String getNombre (){
        return this.nombre;
    }
    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
