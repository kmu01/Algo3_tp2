package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class LugarDeInteres {

    protected HashMap<String,Pista> pistas;
    public LugarDeInteres(){}
    void visitar(GradoDePolicia grado){
        this.obtenerPista(grado).mostrarPista();
    }
    public Pista obtenerPista(GradoDePolicia grado){
        return grado.buscarPista(this.pistas);
    }
    void agregarPista(String dificultad,String descripcion){
        this.pistas.put(dificultad, new PistaFacil(descripcion));
    }
}
