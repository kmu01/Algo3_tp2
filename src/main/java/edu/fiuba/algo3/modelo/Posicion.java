package edu.fiuba.algo3.modelo;

public class Posicion {
    private int latitud;
    private int longitud;

    public Posicion(int latitud, int longitud){
        this.latitud = latitud;
        this.longitud = longitud;
    }
    public int getLatitud(){
        return (this.latitud);
    }
    public int getLongitud(){
        return(this.longitud);
    }
}
