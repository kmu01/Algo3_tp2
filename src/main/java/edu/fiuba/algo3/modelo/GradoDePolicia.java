package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public interface GradoDePolicia {
    int calcularTiempoDeViaje(int kilometros);
    Pista buscarPista(HashMap<String, Pista> pistas);
}
