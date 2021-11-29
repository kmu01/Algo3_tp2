package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Banco implements LugarDeInteres {
    private Pista pista;
    public Banco(){
        this.pista = new PistaFacil("pista1banco");
    }
    public String visitar(GradoDePolicia grado){
        return (this.pista.mostrarPista());
    }
}
