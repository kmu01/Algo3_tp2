package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Investigador implements GradoDePolicia {
    private final int tiempoDeViaje = 1300;
    private final String nivelDePistaDisponible = "dificil";
    public Investigador(){
    }

    @Override
    public int calcularTiempoDeViaje(int kilometros) {
        return kilometros/(this.tiempoDeViaje);
    }


    @Override
    public Pista buscarPista(HashMap<String, Pista> pistas){
        return pistas.get(this.nivelDePistaDisponible);
    }
}