package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.grados.GradoDePolicia;

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

    public Pista visitar(Lugar lugarSeleccionado, GradoDePolicia grado, Cronometro cronometro, Random dado) {

        return lugarSeleccionado.visitar(grado,this.pistas, cronometro,dado);

    }

    public void agregarPista(Pista pista){
        this.pistas.add(pista);
    }

    //todo sacar a futuro
    /*public boolean esCiudad(Ciudad ciudadFinal) {
        return ciudadFinal.esCiudad(this.nombre);
    }
    public boolean esCiudad(String ciudadFinal){
        return (ciudadFinal.equals(this.nombre));
    }*/
}
