package edu.fiuba.algo3.modelo;

public class Posicion {
    private int latitud;
    private int longitud;

    public Posicion(int latitud, int longitud){
        this.latitud = latitud;
        this.longitud = longitud;
    }
    public int latitud(){
        return (this.latitud);
    }
    public int longitud(){
        return(this.longitud);
    }
}
