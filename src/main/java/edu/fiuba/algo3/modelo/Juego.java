package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Juego {
    private static Juego juego;
    private Partida partida;

    public Juego(){
        try {
            this.partida = new Partida(new InicializadorDeArchivos(),new Random());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Juego obtenerInstancia(){
        if(juego==null){
            juego = new Juego();
        }
        return juego;
    }
    public void resetear(){
        juego = null;
    }

    public Pista entrarEdificio(String lugarSeleccionado){
        return this.partida.entrarEdificio(lugarSeleccionado);
    }

    public List<String> getLugares(){
        return this.partida.mostrarLugares();
    }

    public void nuevoCaso(Integer cantidadDeArrestos) throws IOException {
        this.partida.nuevoCaso(cantidadDeArrestos);
    }

    public List<String> getDestinos(){
        return this.partida.getListaDestinos();
    }
}





