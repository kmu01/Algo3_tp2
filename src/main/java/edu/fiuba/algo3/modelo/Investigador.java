package edu.fiuba.algo3.modelo;

public class Investigador extends GradoDePolicia {

    public Investigador(){
        super();
        this.tiempoDeViaje = 1300;
        this.tiempoDeDescanso = 8;
        this.dificultad = new Dificultad("Medio");

    }

}