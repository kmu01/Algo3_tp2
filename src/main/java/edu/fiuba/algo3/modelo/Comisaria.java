package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Comisaria {
    private List<Ladron> sospechosos;

    public Comisaria(List<Ladron> ladrones){
        this.sospechosos = ladrones;
    }

    public void cargarDatos(Sospechoso sospechoso){
        List<Ladron> ladrones = new ArrayList<Ladron>();
        for (Ladron ladron:this.sospechosos) {
            if (ladron.equals(sospechoso)){
                ladrones.add(ladron);
            }
        }

    }


}
