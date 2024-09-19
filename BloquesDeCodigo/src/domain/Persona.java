package domain;

public class Persona {
    //bloques de inicializacion estaticos o no estaticos, se llaman antes del constructor.

    private final int idPersonas;
    private static int contadorPersona;

    //definir bloque de codigo de inicializacion estatico y antes de un bloque de inicializacion no estatico
    //se ejecuta solo la primera vez que se carga la clase en memoria
    static{
        System.out.println("Ejecucion bloque static");
        ++Persona.contadorPersona;
    }
    //bloque de inicializacion no estatico, o contexto dinámico
    //se ejecuta cada vez que se crea un nuevo objeto
    {
        System.out.println("Ejecucion bloque no statico");
        this.idPersonas = Persona.contadorPersona++;
    }

    public Persona (){
        System.out.println("ejecucion del constructor");
    }

    public int getIdPersonas (){
        return this.idPersonas;
    }

}
