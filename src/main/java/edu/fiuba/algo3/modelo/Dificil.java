package edu.fiuba.algo3.modelo;

public class Dificil implements NivelDePista {

    private final String nivel = "Dificil";

    public Dificil(){}

    public boolean esNivel(NivelDePista nivel){

        return this.nivel.equals(nivel.obtenerNivelPista());

    }

    public String obtenerNivelPista (){
        return this.nivel;
    }
}
