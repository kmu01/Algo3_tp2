package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class Novato extends GradoDePolicia {

    public Novato(){
        super();

        this.tiempoDeViaje = 900;
        this.tiempoDeDescanso = 8;
        this.dificultadMasFrecuente = new Dificultad("Facil");
        this.dificultadMenosFrecuente = new Dificultad("Medio");
        this.rarezaMasFrecuente = "comun";
        this.rarezaMenosFrecuente = "valioso";
    }

}
