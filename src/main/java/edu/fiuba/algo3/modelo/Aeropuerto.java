package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class Aeropuerto extends LugarDeInteres{

    public Aeropuerto(){
        super();
        this.pistas = new HashMap<String, Pista>();
    }
}
