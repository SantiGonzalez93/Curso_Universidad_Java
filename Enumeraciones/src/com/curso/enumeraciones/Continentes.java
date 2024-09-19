package com.curso.enumeraciones;

public enum Continentes {
    //cada uno de los elementos de la enumeracion es una constante (publico, estatico, final)
    //entre parentesis son los artibutos pertenecientes al elemento y estos son privados.

    AFRICA( 34),
    AMERICA( 35),
    OCEANIA( 36),
    ASIA( 37),
    EUROPA( 38);


    //pusimos final solo para no poder modificarlo, pero podria no ser final
    private  final int paises;

    Continentes (int paises){
        this.paises = paises;
    }

    public int getPaises(){
        return this.paises;
    }

}
