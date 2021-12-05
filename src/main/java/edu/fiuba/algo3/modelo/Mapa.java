package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
public class Mapa {

    private Map<Ciudad, Posicion> posiciones;

    public Mapa(){

        this.posiciones = new HashMap<>();

    }

    public float calcularDistancia (Ciudad ciudadSeleccionada,Ciudad ciudadActual){

        float latitudActual = posiciones.get(ciudadActual).latitud();
        float longitudActual = posiciones.get(ciudadActual).longitud();
        float latitudSeleccionada = posiciones.get(ciudadSeleccionada).latitud();
        float longitudSeleccionada = posiciones.get(ciudadSeleccionada).longitud();

        return (float) sqrt(pow((longitudSeleccionada-longitudActual),2)+pow((latitudSeleccionada-latitudActual),2));

    }

    public void agregarCiudad (Ciudad ciudad, float latitud, float longitud){

        this.posiciones.put(ciudad,new Posicion(latitud,longitud));

    }

}
