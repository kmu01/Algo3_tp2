package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.grados.GradoDePolicia;

import java.util.List;
import java.util.Random;

public class Lugar {
    private String nombre;
    public Lugar(String nombre){
        this.nombre = nombre;
    }
    public Pista visitar(GradoDePolicia grado, List<Pista> pistas, Cronometro cronometro, Random dado){
        return (this.obtenerPista(grado,pistas,dado).obtenerPista(cronometro));

    }
    private Pista obtenerPista(GradoDePolicia grado, List<Pista> pistas, Random dado){
        return grado.buscarPista(pistas,this.nombre,dado);
    }


}
