package edu.fiuba.algo3.modelo.ubicacion;

public class Posicion {
    private float latitud;
    private float longitud;

    public Posicion(float latitud, float longitud){
        this.latitud = latitud;
        this.longitud = longitud;
    }
    public float latitud(){
        return (this.latitud);
    }
    public float longitud(){
        return(this.longitud);
    }
}
