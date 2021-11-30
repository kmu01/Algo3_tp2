package edu.fiuba.algo3.modelo;

public class Tiempo {
    private int hora;
    private final int tiempoLimite = 158;
    public Tiempo(){
        this.hora = 0;

    }
    public void agregarTiempo(int tiempoDeLaAccion ) throws Exception {
        this.hora += tiempoDeLaAccion;
        if(controlarLimite()){
            throw new Exception("Termino el juego");
        }
    }
    private boolean controlarLimite(){
        return (this.hora >= this.tiempoLimite);
    }

}
