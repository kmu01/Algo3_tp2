package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Biblioteca implements LugarDeInteres{

    private HashMap<String,Pista> pistas;

    public Biblioteca() {

        this.pistas = new HashMap<String, Pista>();
        this.pistas.put("novato", new PistaFacil("pistaNovatoBiblioteca"));
    }
    @Override
    public String visitar(GradoDePolicia grado){

        return this.obtenerPista(grado).mostrarPista();
    }

    @Override
    public Pista obtenerPista(GradoDePolicia grado){

        return grado.buscarPista(this.pistas);
    }

}
