package edu.fiuba.algo3.modelo.ubicacion;

import edu.fiuba.algo3.modelo.excepciones.TiempoTerminadoException;
import edu.fiuba.algo3.modelo.grados.GradoDePolicia;
import edu.fiuba.algo3.modelo.tablero.Pista;

import java.util.List;
import java.util.Random;

public class Lugar {
    private String nombre;
    public Lugar(String nombre){
        this.nombre = nombre;
    }
    public Pista visitar(GradoDePolicia grado, List<Pista> pistas, Cronometro cronometro, Random dado) throws TiempoTerminadoException {
        return (this.obtenerPista(grado,pistas,dado).obtenerPista(cronometro));

    }
    private Pista obtenerPista(GradoDePolicia grado, List<Pista> pistas, Random dado){
        return grado.buscarPista(pistas,this.nombre,dado);
    }


}
