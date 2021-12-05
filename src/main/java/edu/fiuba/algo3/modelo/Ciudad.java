package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

public class Ciudad {
    private String nombre;
    protected List<Pista> pistas;
    public Ciudad(String nombre, List<Pista> pistas){

        this.nombre = nombre;
        this.pistas = pistas;
    }

    public Ciudad (String nombre){

        this.nombre = nombre;

    }

    public Pista visitar(Lugar lugarSeleccionado, GradoDePolicia grado, Cronometro cronometro){

        return lugarSeleccionado.visitar(grado,this.pistas, cronometro);

    }
    public String nombre(){
        return (this.nombre);
    }

    public void agregarPista(Pista pista){
        this.pistas.add(pista);
    }

}
