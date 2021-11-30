package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public interface LugarDeInteres {
    void visitar(GradoDePolicia grado);
    Pista obtenerPista(GradoDePolicia grado);
    void agregarPista(String dificultad,String descripcion);
}
