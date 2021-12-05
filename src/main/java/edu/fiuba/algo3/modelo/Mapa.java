package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
public class Mapa {

    private Map<String, Posicion> posiciones;

    public Mapa(){

        this.posiciones = new HashMap<>();

    }

    public int calcularDistancia (String ciudadSeleccionada,String ciudadActual){

        int latitudActual = posiciones.get(ciudadActual).latitud();
        int longitudActual = posiciones.get(ciudadActual).longitud();
        int latitudSeleccionada = posiciones.get(ciudadSeleccionada).latitud();
        int longitudSeleccionada = posiciones.get(ciudadSeleccionada).longitud();

        return (int) sqrt(pow((longitudSeleccionada-longitudActual),2)+pow((latitudSeleccionada-latitudActual),2));

    }

    public void agregarCiudad (String nombreCiudad, int latitud, int longitud){

        this.posiciones.put(nombreCiudad,new Posicion(latitud,longitud));

    }

}
