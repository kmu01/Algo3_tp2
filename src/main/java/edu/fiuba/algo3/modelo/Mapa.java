package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
public class Mapa {

    private Map<Ciudad, Posicion> posiciones;
    private final int factorAKm = 100;
    public Mapa(){

        this.posiciones = new HashMap<>();

    }

    public float calcularDistancia (Ciudad ciudadSeleccionada,Ciudad ciudadActual){

        float latitudEnKmActual = posiciones.get(ciudadActual).latitud()*factorAKm;
        float longitudEnKmActual = posiciones.get(ciudadActual).longitud()*factorAKm;
        float latitudEnKmSeleccionada = posiciones.get(ciudadSeleccionada).latitud()*factorAKm;
        float longitudEnKmSeleccionada = posiciones.get(ciudadSeleccionada).longitud()*factorAKm;
        System.out.println();
        return (float) sqrt(pow((longitudEnKmSeleccionada-longitudEnKmActual),2)+pow((latitudEnKmSeleccionada-latitudEnKmActual),2));

    }

    public void agregarCiudad (Ciudad ciudad, float latitud, float longitud){

        this.posiciones.put(ciudad,new Posicion(latitud,longitud));

    }

}
