package edu.fiuba.algo3.modelo;

import java.util.*;

public class Ciudad {
    private String nombre;
    protected List<Pista> pistas;
    public Ciudad(String nombre, List<Pista> pistas){

        this.nombre = nombre;
        this.pistas = pistas;
    }

    public Ciudad (String nombre){
        this.pistas = new ArrayList<>();
        this.nombre = nombre;

    }

    public Ciudad() {

    }

    public Pista visitar(Lugar lugarSeleccionado, GradoDePolicia grado, Cronometro cronometro, Random dado){

        return lugarSeleccionado.visitar(grado,this.pistas, cronometro,dado);

    }
    public String nombre(){
        return (this.nombre);
    }

    public void agregarPista(Pista pista){
        this.pistas.add(pista);
    }

}
