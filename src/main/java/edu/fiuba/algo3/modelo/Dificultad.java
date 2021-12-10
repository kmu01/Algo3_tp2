package edu.fiuba.algo3.modelo;

public class Dificultad {

    private final String dificultad;

    public Dificultad (String dificultad){

        this.dificultad = dificultad;

    }

    public boolean esDificultad( Dificultad dificultad){
        return dificultad.esDificultad(this.dificultad);
    }

    public boolean esDificultad(String dificultad){
        return (this.dificultad.equals(dificultad));
    }
}
