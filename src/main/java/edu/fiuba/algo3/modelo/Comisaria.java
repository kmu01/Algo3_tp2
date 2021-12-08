package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Comisaria {

    private List<Ladron> ladronesBuscados;

    public Comisaria(List<Ladron> ladrones){
        this.ladronesBuscados = ladrones;
    }

    public List<Ladron> cargarDatos(Sospechoso sospechoso){

        List<Ladron> ladrones = new ArrayList<>();
        int mayorAtributosIguales = 0;
        for (Ladron ladron:this.ladronesBuscados) {
            int cantidadDeAtributosIguales = ladron.esIgual(sospechoso);
            if (cantidadDeAtributosIguales > mayorAtributosIguales){
                ladrones.clear();
                ladrones.add(ladron);
                mayorAtributosIguales = cantidadDeAtributosIguales;
            }else if(cantidadDeAtributosIguales == mayorAtributosIguales){
                ladrones.add(ladron);
            }
        }

        return ladrones;
    }


}
