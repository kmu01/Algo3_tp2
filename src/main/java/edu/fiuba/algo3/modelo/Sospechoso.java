package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Sospechoso {

    private List<Cualidad> cualidades;

    public Sospechoso (){

        this.cualidades = new ArrayList<>();

    }

    public void anotarCualidad(Cualidad cualidad){
        this.cualidades.add(cualidad);
    }

    public int esIgual(List<Cualidad> cualidades) {
        int cantidadDeAtributosIguales = 0;
        for (int i = 0; i < this.cualidades.size(); i++) {
            for (Cualidad cualidad: cualidades) {
                if (cualidad.esCualidad(this.cualidades.get(i))) cantidadDeAtributosIguales++;
            }
        }
        return cantidadDeAtributosIguales;
    }
}
