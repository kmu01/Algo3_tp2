package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sospechoso {

    private List<Cualidad> cualidades;

    public Sospechoso (){

        this.cualidades = new ArrayList<>();

    }

    public void anotarCualidad(Cualidad cualidad){
        this.cualidades.add(cualidad);
    }

    public int esIgual(List<Cualidad> cualidades) {
        /*int cantidadDeAtributosIguales = 0;
        for (Cualidad cualidad: cualidades) {
            this.cualidades.stream().filter(cualidad::esCualidad);
        }*/
        return this.cualidades.stream().filter(deSospechoso -> cualidades.stream().anyMatch(deLadron -> deLadron.esCualidad(deSospechoso))).collect(Collectors.toList()).size();


        /*for (int i = 0; i < this.cualidades.size(); i++) {
            for (Cualidad cualidad: cualidades) {
                if (cualidad.esCualidad(this.cualidades.get(i))) cantidadDeAtributosIguales++;
            }
        }
        return cantidadDeAtributosIguales;*/
    }
}
