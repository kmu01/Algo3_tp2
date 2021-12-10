package edu.fiuba.algo3.modelo;

import java.util.List;

public class OrdenEmitida implements OrdenDeArresto{
    private Ladron ladron;
    public OrdenEmitida(Ladron ladron){
        this.ladron = ladron;
    }

    public OrdenDeArresto emitir(List<Ladron> ladrones){
        return (new OrdenEmitida(this.ladron));
    }

    public boolean emitida(){
            return true;
    }
}
