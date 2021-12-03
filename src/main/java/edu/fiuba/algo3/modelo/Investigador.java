package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;

public class Investigador implements GradoDePolicia {
    private final int tiempoDeViaje = 1300;
    private final NivelDePista nivelDePistaDisponible = new Medio();
    public Investigador(){
    }

    @Override
    public int calcularTiempoDeViaje(int kilometros) {
        return kilometros/(this.tiempoDeViaje);
    }


    @Override
    public Pista buscarPista(List<Pista> pistas,String nombreLugar){
        Pista pistaSeleccionada = null;
        for (int i = 0 ; i < pistas.size() ; i++){
            Pista pista = pistas.get(i);
            if(pista.esPista(this.nivelDePistaDisponible,nombreLugar)){
                pistaSeleccionada = pista;
            }
        }
        return pistaSeleccionada;
    }
}