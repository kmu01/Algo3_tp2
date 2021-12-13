package edu.fiuba.algo3.modelo.grados;

import edu.fiuba.algo3.modelo.Dificultad;

public class Sargento extends GradoDePolicia {

    public Sargento(){

        this.tiempoDeViaje = 1500;
        this.tiempoDeDescanso = 8;
        this.tiempoDeHeridaDeBala = 4;
        this.dificultadMasFrecuente = new Dificultad("Dificl");
        this.dificultadMenosFrecuente = new Dificultad("Medio");
        this.rarezaMasFrecuente = "muy valioso";
        this.rarezaMenosFrecuente = "valioso";
    }

}