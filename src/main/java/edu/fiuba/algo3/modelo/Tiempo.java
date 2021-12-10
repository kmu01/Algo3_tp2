package edu.fiuba.algo3.modelo;

public class Tiempo {

    private int hora;
    private final int tiempoLimite = 158;

    public Tiempo(){

        this.hora = 0;

    }
    public void agregarTiempo(float tiempoDeLaAccion) throws GameOverException {

        this.hora += tiempoDeLaAccion;

        if (this.finalizado()){
            throw new GameOverException();
        }
    }

    private boolean finalizado(){
        return (this.hora >= this.tiempoLimite);
    }

    public int tiempoTranscurrido() {

        return this.hora;

    }
}
