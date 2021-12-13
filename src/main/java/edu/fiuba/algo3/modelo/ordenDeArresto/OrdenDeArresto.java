package edu.fiuba.algo3.modelo.ordenDeArresto;

import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.excepciones.NoHayLadronesException;

import java.util.List;

public interface OrdenDeArresto {

    boolean emitida();
    OrdenDeArresto emitir(List<Ladron> ladrones);

}
