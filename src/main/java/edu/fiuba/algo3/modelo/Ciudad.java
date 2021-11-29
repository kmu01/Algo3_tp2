package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ciudad {
    private String nombre;
    private Map<String,LugarDeInteres> lugares;

    public Ciudad(String nombre){

        this.nombre = nombre;
        this.lugares = new HashMap<String, LugarDeInteres>();
        lugares.put("banco",new Banco());
        lugares.put("biblioteca",new Biblioteca());
        lugares.put("aeropuerto",new Aeropuerto());
        lugares.put("puerto",new Puerto());

    }

    public String visitar(String lugarSeleccionado, GradoDePolicia grado){
        return lugares.get(lugarSeleccionado).visitar(grado);
    }
    public String nombre(){
        return (this.nombre);
    }
}
