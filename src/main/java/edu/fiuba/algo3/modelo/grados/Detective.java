package edu.fiuba.algo3.modelo.grados;

import edu.fiuba.algo3.modelo.Dificultad;

public class Detective extends GradoDePolicia {

    public Detective(){
        super();

        this.tiempoDeViaje = 1100;
        this.tiempoDeDescanso = 8;
        this.dificultadMasFrecuente = new Dificultad("Medio");
        this.dificultadMenosFrecuente = new Dificultad("Facil");
        this.rarezaMasFrecuente = "valioso";
        this.rarezaMenosFrecuente = "comun";
    }
}