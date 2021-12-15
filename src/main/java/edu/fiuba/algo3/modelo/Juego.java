package edu.fiuba.algo3.modelo;

import java.io.IOException;
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
}
