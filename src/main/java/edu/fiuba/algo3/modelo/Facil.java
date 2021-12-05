package edu.fiuba.algo3.modelo;

public class Facil implements NivelDePista{

    private final String nivel = "facil";

    public Facil (){}

    public boolean esNivel(NivelDePista nivel){

        return this.nivel.equals(nivel.obtenerNivelPista());

    }

    public String obtenerNivelPista (){
        return this.nivel;
    }

}
