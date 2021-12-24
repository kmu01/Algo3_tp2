package edu.fiuba.algo3.modelo.objetos;


import edu.fiuba.algo3.modelo.ubicacion.Ciudad;
import edu.fiuba.algo3.modelo.comisaria.Policia;
import edu.fiuba.algo3.modelo.grados.GradoDePolicia;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public interface ObjetoRobado {


    String rareza();

    int cantidadPaises();

    boolean verificarLimitePaises(int cantidadDePaisesVisitados);

    Policia crearPoliciaConCiudadInicial(GradoDePolicia grado);

    Queue<Ciudad> setearRutaLadron(List<String> nombresDeCiudades, Map<String, Ciudad> ciudades, Random dado, Queue<Ciudad> rutaLadron);

    String nombreTesoro();
}
