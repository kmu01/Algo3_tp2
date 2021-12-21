package edu.fiuba.algo3.modelo.ordenDeArresto;

import edu.fiuba.algo3.modelo.ubicacion.Cronometro;
import edu.fiuba.algo3.modelo.comisaria.Ladron;

import java.util.List;

public class OrdenSinEmitir implements OrdenDeArresto {
    private int tiempoDeDemora = 3;
    public OrdenSinEmitir(){
    }
    @Override
    public OrdenDeArresto emitir(List<Ladron> ladronesPosibles, Cronometro cronometro) {
        if(ladronesPosibles.size() == 1){
            cronometro.calcularTiempoEnGenerarOrdenDeArresto(tiempoDeDemora);
            return (new OrdenEmitida(ladronesPosibles.get(0)));
        }
        return (this);
    }
    @Override
    public boolean emitida(){
        return false;
    }
}