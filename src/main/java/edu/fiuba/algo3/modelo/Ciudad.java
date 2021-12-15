package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.grados.GradoDePolicia;

import java.util.*;

public class Ciudad {
    private String nombre;
    protected List<Pista> pistas;
    private List<Ciudad> destinos;

    public Ciudad(String nombre, List<Pista> pistas){

        this.nombre = nombre;
        this.pistas = pistas;
    }

    public Ciudad (String nombre){
        this.pistas = new ArrayList<>();
        this.nombre = nombre;

    }

    public Pista visitar(Lugar lugarSeleccionado, GradoDePolicia grado, Cronometro cronometro, Random dado) {

        return lugarSeleccionado.visitar(grado,this.pistas, cronometro,dado);

    }

    public void agregarDestino(Ciudad destino) {this.destinos.add(destino);}

    public void agregarPista(Pista pista){
        this.pistas.add(pista);
    }

}
