package edu.fiuba.algo3.modelo;

import java.util.List;

public interface OrdenDeArresto {

    boolean emitida();
    OrdenDeArresto emitir(List<Ladron> ladrones);

}
