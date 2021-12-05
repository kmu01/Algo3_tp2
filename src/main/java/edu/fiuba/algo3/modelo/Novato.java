package edu.fiuba.algo3.modelo;

public class Novato extends GradoDePolicia {

    public Novato(){
        super();

        this.tiempoDeViaje = 900;
        this.tiempoDeDescanso = 8;
        this.dificultad = new Dificultad("facil");
    }

}
