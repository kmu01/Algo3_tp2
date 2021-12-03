package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

public class Ciudad {
    private String nombre;
    //private List<Lugar> lugares;
    protected List<Pista> pistas;
    public Ciudad(String nombre){

        this.nombre = nombre;
        this.pistas = new ArrayList<Pista>();
        //this.lugares = new HashMap<String, LugarDeInteres>();
        //this.lugares = new ArrayList<Lugar>();

        /*lugares.put("banco",new Banco());
        lugares.put("biblioteca",new Banco());
        lugares.put("aeropuerto",new Banco());
        lugares.put("puerto",new Banco());
        lugares.put("bolsa",new Banco());
        */
    }

    public Evidencia visitar(Lugar lugarSeleccionado, GradoDePolicia grado){
        return lugarSeleccionado.visitar(grado,this.pistas);
    }
    public String nombre(){
        return (this.nombre);
    }

    public void agregarPista(Pista pista){
        this.pistas.add(pista);
    }

}
