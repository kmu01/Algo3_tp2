package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.comisaria.Ladron;
import edu.fiuba.algo3.modelo.tablero.InicializadorDeArchivos;
import edu.fiuba.algo3.modelo.tablero.Partida;
import edu.fiuba.algo3.modelo.tablero.Pista;
import edu.fiuba.algo3.modelo.tablero.RutaLadron;
import edu.fiuba.algo3.modelo.ubicacion.Ciudad;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Juego {
    private static Juego juego;
    private Partida partida;

    public Juego(){
        try {
            this.partida = new Partida(new InicializadorDeArchivos(),new Random(),new RutaLadron());
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

    public String hora(){
        return this.partida.hora();
    }

    public void resetear(){
        juego = null;
    }

    public String obtenerNombreTesoro(){
        return this.partida.obtenerNombreDeTesoro();
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

    public Ciudad getCiudadActual() {
        return this.partida.obtenerCiudadActual();
    }

    public int viajar(String ciudadSeleccionada) {
        return this.partida.viajar(ciudadSeleccionada);
    }

    public void anotarCualidad(String atributo) {
        this.partida.anotarCualidad(atributo);
    }

    public List<Ladron> buscarLadrones() {
        return this.partida.buscarLadrones();
    }

    public String getGrado() {return this.partida.obtenerGrado();}
}





