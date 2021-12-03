package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;

public class Sargento implements GradoDePolicia {
    private final int tiempoDeViaje = 1500;
    private final NivelDePista nivelDePistaDisponible = new Dificil();
    public Sargento(){
    }

    @Override
    public int calcularTiempoDeViaje(int kilometros) {
        return kilometros/(this.tiempoDeViaje);
    }


    @Override
    public Pista buscarPista(List<Pista> pistas, String nombreLugar){
        Pista pistaSeleccionada = null;
        for (int i = 0 ; i < pistas.size() ; i++){
            Pista pista = pistas.get(i);
            if(pista.esPista(this.nivelDePistaDisponible,nombreLugar)){
                pistaSeleccionada = pista;
            }
        }
        // Aca falta una excepcion
        return pistaSeleccionada;
    }
}