package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Puerto implements LugarDeInteres{

    private HashMap<String,Pista> pistas;

    public Puerto(){
        this.pistas = new HashMap<String, Pista>();
        this.pistas.put("novato", new PistaFacil("pistaNovatoPuerto"));
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
