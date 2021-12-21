package edu.fiuba.algo3.modelo.ordenDeArresto;

import edu.fiuba.algo3.modelo.ubicacion.Cronometro;
import edu.fiuba.algo3.modelo.comisaria.Ladron;

import java.util.List;

public class OrdenEmitida implements OrdenDeArresto {
    private Ladron ladron;
    public OrdenEmitida(Ladron ladron){
        this.ladron = ladron;
    }

    public OrdenDeArresto emitir(List<Ladron> ladrones, Cronometro cronometro){
        return (new OrdenEmitida(this.ladron));
    }

    public boolean emitida(){
            return true;
    }
}
