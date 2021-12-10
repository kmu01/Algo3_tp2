package edu.fiuba.algo3.modelo.objetos;


import edu.fiuba.algo3.modelo.Ciudad;

public interface ObjetoRobado {

    Ciudad ciudad();

    String rareza();

    int cantidadPaises();

    boolean verificarLimitePaises(int cantidadDePaisesVisitados);
}
