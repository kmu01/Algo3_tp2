package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class Investigador extends GradoDePolicia {

    public Investigador(){
        super();
        this.tiempoDeViaje = 1300;
        this.tiempoDeDescanso = 8;
        this.dificultadMasFrecuente = new Dificultad("Medio");
        this.dificultadMenosFrecuente = new Dificultad("Dificil");
        this.rarezaMasFrecuente = "valioso";
        this.rarezaMenosFrecuente = "muy valioso";
    }

}