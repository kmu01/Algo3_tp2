package edu.fiuba.algo3.modelo;

public class Tiempo {

    private float hora;
    private final float tiempoLimite = 158;

    public Tiempo(){

        this.hora = 0;

    }
    public void agregarTiempo(float tiempoDeLaAccion) {

        this.hora += tiempoDeLaAccion;

    }

    public boolean finalizado(){
        return (this.hora >= this.tiempoLimite);
    }

    public float tiempoRestante() {

        return this.hora;

    }
}
