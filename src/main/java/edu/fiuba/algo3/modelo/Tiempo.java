package edu.fiuba.algo3.modelo;

public class Tiempo {

    private int hora;
    private final int tiempoLimite = 158;

    public Tiempo(){

        this.hora = 0;

    }
    public void agregarTiempo(float tiempoDeLaAccion) {

        this.hora += tiempoDeLaAccion;

    }

    public boolean finalizado(){
        return (this.hora >= this.tiempoLimite);
    }

    public int tiempoTranscurrido() {

        return this.hora;

    }
}
