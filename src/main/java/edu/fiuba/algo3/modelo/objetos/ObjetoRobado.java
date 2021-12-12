package edu.fiuba.algo3.modelo.objetos;


import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.grados.GradoDePolicia;

public interface ObjetoRobado {


    String rareza();

    int cantidadPaises();

    boolean verificarLimitePaises(int cantidadDePaisesVisitados);

    Policia crearPoliciaConCiudadInicial(GradoDePolicia grado);
}
