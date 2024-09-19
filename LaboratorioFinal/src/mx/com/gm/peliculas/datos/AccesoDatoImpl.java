package mx.com.gm.peliculas.datos;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

import java.io.*;
import java.util.*;

public class AccesoDatoImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        //.exists() return false if the file dosen´t exist, and true if it exists
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        List<Pelicula> pelicula = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + e.getMessage());

        }
    }

        @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {

    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        return "";
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {

    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {

    }
}
