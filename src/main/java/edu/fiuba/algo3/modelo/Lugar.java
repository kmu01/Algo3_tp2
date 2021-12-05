package edu.fiuba.algo3.modelo;

import java.util.List;

public class Lugar {
    private String nombre;
    public Lugar(String nombre){
        this.nombre = nombre;
    }
    public Pista visitar(GradoDePolicia grado,List<Pista> pistas, Cronometro cronometro){
        return (this.obtenerPista(grado,pistas).obtenerPista(cronometro));

    }
    private Pista obtenerPista(GradoDePolicia grado, List<Pista> pistas){
        return grado.buscarPista(pistas,this.nombre);
    }


}
