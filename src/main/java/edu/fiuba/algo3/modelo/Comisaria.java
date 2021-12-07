package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Comisaria {

    private List<Ladron> sospechosos;

    public Comisaria(List<Ladron> ladrones){
        this.sospechosos = ladrones;
    }

    public List<Ladron> cargarDatos(Sospechoso sospechoso){

        List<Ladron> ladrones = new ArrayList<>();
        for (Ladron ladron:this.sospechosos) {
            if (ladron.esIgual(sospechoso)){
                ladrones.add(ladron);
            }
        }

        return ladrones;
    }


}
