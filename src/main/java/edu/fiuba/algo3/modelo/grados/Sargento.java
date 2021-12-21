package edu.fiuba.algo3.modelo.grados;

import edu.fiuba.algo3.modelo.tablero.Dificultad;

public class Sargento extends GradoDePolicia {

    public Sargento(){

        this.tiempoDeViaje = 1500;
        this.tiempoDeDescanso = 8;
        this.tiempoDeHeridaDeBala = 4;
        this.dificultadMasFrecuente = new Dificultad("Dificil");
        this.dificultadMenosFrecuente = new Dificultad("Medio");
        this.rarezaMasFrecuente = "muy valioso";
        this.rarezaMenosFrecuente = "valioso";
    }

}