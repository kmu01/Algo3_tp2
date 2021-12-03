package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;

public interface GradoDePolicia {
    int calcularTiempoDeViaje(int kilometros);
    Pista buscarPista(List<Pista> pistas,String nombreLugar);
}
