package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lugar {
    private String nombre;
    public Lugar(String nombre){
        this.nombre = nombre;
    }
    public Evidencia visitar(GradoDePolicia grado,List<Pista> pistas){
        return (this.obtenerPista(grado,pistas).pedirEvidencia());

    }
    private Pista obtenerPista(GradoDePolicia grado, List<Pista> pistas){
        return grado.buscarPista(pistas,this.nombre);
    }


}
