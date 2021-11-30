package edu.fiuba.algo3.modelo;


import java.util.HashMap;


public class Banco implements LugarDeInteres {
    private Pista pista;
    public Banco(){
        this.pista = new PistaFacil("pista1banco");
    }

    @Override
    public String visitar(GradoDePolicia grado){

        return this.obtenerPista(grado).mostrarPista();
    }
}
