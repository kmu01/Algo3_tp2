package edu.fiuba.algo3.modelo;

import java.util.List;

public class OrdenSinEmitir implements OrdenDeArresto{
    public OrdenSinEmitir(){
    }
    @Override
    public OrdenDeArresto emitir(List<Ladron> ladronesPosibles){
        if(ladronesPosibles.size() == 1){
            return (new OrdenEmitida(ladronesPosibles.get(0)));
        }
        return (this);
    }
    @Override
    public boolean emitida(){
        return false;
    }
}