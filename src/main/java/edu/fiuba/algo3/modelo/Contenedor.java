package edu.fiuba.algo3.modelo;

import java.util.Map;

public class Contenedor {
    private Mapa mapa;
    private Map<String,Ciudad> ciudades;
    public Contenedor(){
        this.mapa = null;
        this.ciudades = null;
    }


    public void contenerMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public void contenerCiudades(Map<String, Ciudad> ciudades) {
        this.ciudades=ciudades;
    }
    public Map<String,Ciudad> devolverCiudades(){
        return (this.ciudades);
    }
    public Mapa devolverMapa(){
        return (this.mapa);
    }
}
