package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

public class Ciudad {
    private String nombre;
    private Map<String,LugarDeInteres> lugares;

    public Ciudad(String nombre){

        this.nombre = nombre;
        this.lugares = new HashMap<String, LugarDeInteres>();

        lugares.put("banco",new Banco());
        lugares.put("biblioteca",new Biblioteca());
        lugares.put("aeropuerto",new Aeropuerto());
        lugares.put("puerto",new Puerto());
        lugares.put("bolsa",new Bolsa());

    }

    public void visitar(String lugarSeleccionado, GradoDePolicia grado){
        this.lugares.get(lugarSeleccionado).visitar(grado);
    }
    public String nombre(){
        return (this.nombre);
    }

    public void agregarPista(String dificultad,String descripcion,String lugarElegido){
        this.lugares.get(lugarElegido).agregarPista(dificultad,descripcion);
    }

}
