package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Sargento implements GradoDePolicia {
    private final int tiempoDeViaje = 1500;
    private final String nivelDePistaDisponible = "dificil";
    public Sargento(){
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