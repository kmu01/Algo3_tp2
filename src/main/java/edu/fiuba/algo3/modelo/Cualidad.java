package edu.fiuba.algo3.modelo;

public class Cualidad{

    private String cualidad;

    public Cualidad (String cualidad){
        this.cualidad = cualidad;
    }

    public int esCualidad(Cualidad cualidad, int contador){
        if(this.cualidad.equals(cualidad.cualidad)){
            contador++;
        }
        return  contador;
    }

}
