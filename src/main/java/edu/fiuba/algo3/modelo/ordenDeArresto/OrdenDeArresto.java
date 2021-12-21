package edu.fiuba.algo3.modelo.ordenDeArresto;

import edu.fiuba.algo3.modelo.ubicacion.Cronometro;
import edu.fiuba.algo3.modelo.comisaria.Ladron;

import java.util.List;

public interface OrdenDeArresto {

    boolean emitida();
    OrdenDeArresto emitir(List<Ladron> ladrones, Cronometro cronometro);

}
