package edu.fiuba.algo3.modelo;

public class Sargento extends GradoDePolicia {

    public Sargento(){
        super();

        this.tiempoDeViaje = 1500;
        this.tiempoDeDescanso = 8;
        this.nivelDePistaDisponible = new Dificil();

    }

}