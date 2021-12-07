package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

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