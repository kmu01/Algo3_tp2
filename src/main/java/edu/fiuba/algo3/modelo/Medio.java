package edu.fiuba.algo3.modelo;

public class Medio implements NivelDePista {

    private String nivel = "Medio";
    public Medio(){}

    @Override
    public boolean esNivel(NivelDePista nivel){

        return this.nivel.equals(nivel.obtenerNivelPista());

    }

    @Override
    public String obtenerNivelPista(){

        return this.nivel;
    }
}
