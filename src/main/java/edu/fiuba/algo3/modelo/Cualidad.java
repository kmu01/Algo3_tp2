package edu.fiuba.algo3.modelo;

public class Cualidad{

    private String cualidad;

    public Cualidad (String cualidad){
        this.cualidad = cualidad;
    }

    public Boolean esCualidad(Cualidad cualidad){
        return cualidad.compararCualidades(this.cualidad);
    }

    public Boolean compararCualidades(String cualidad){
        return this.cualidad.equals(cualidad);
    }
}