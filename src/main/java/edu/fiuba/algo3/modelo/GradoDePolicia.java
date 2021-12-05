package edu.fiuba.algo3.modelo;

import java.util.List;

public class GradoDePolicia {

    protected int tiempoDeViaje;
    protected int tiempoDeDescanso;
    protected Dificultad dificultad;

    public GradoDePolicia (){}

    public void calcularTiempoDeViaje(int distancia, Cronometro cronometro) {

        cronometro.calcularTiempoDeViaje(distancia, this.tiempoDeViaje);

    }

    public void calcularTiempoDurmiendo(Cronometro cronometro) {

        cronometro.calcularTiempoDurmiendo(this.tiempoDeDescanso);

    }

    public Pista buscarPista(List<Pista> pistas,String nombreLugar){
        Pista pistaSeleccionada = null;
        for (int i = 0 ; i < pistas.size() ; i++){
            Pista pista = pistas.get(i);
            if(pista.esPista(this.dificultad,nombreLugar)){
                pistaSeleccionada = pista;
            };
        }
        return pistaSeleccionada;
    }
}
