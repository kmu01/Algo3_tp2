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
        return this.cualidades.stream().filter(deSospechoso -> cualidades.stream().anyMatch(deLadron -> deLadron.esCualidad(deSospechoso))).collect(Collectors.toList()).size();
    }
}
