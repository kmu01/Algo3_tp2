package edu.fiuba.algo3.modelo.grados;

import edu.fiuba.algo3.modelo.Dificultad;

public class Investigador extends GradoDePolicia {

    public Investigador(){
        this.tiempoDeViaje = 1300;
        this.tiempoDeDescanso = 8;
        this.tiempoDeHeridaDeBala = 4;
        this.dificultadMasFrecuente = new Dificultad("Medio");
        this.dificultadMenosFrecuente = new Dificultad("Dificil");
        this.rarezaMasFrecuente = "valioso";
        this.rarezaMenosFrecuente = "muy valioso";
    }

}