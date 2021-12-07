package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class Sargento extends GradoDePolicia {

    public Sargento(){
        super();

        this.tiempoDeViaje = 1500;
        this.tiempoDeDescanso = 8;
        this.dificultadMasFrecuente = new Dificultad("Dificl");
        this.dificultadMenosFrecuente = new Dificultad("Medio");
        this.rarezaMasFrecuente = "muy valioso";
        this.rarezaMenosFrecuente = "valioso";
    }

}