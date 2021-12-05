package edu.fiuba.algo3.modelo;

public class Detective extends GradoDePolicia {

    public Detective(){
        super();

        this.tiempoDeViaje = 1100;
        this.tiempoDeDescanso = 8;
        this.nivelDePistaDisponible = new Medio();

    }
}