package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class Sargento extends GradoDePolicia {

    public Sargento(){
        super();

        this.tiempoDeViaje = 1500;
        this.tiempoDeDescanso = 8;
        this.dificultad = new Dificultad("Dificil");
        this.rarezaMasFrecuente = "muy valioso";
        this.rarezaMenosFrecuente = "valioso";
    }

}