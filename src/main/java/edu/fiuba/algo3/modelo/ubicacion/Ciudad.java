package edu.fiuba.algo3.modelo.ubicacion;

import edu.fiuba.algo3.modelo.grados.GradoDePolicia;
import edu.fiuba.algo3.modelo.tablero.Dificultad;
import edu.fiuba.algo3.modelo.tablero.Pista;

import java.util.*;

public class Ciudad {
    private String nombre;
    private List<Pista> pistas;
    private List<String> destinos;
    private List<String> lugares;

    public Ciudad(String nombre, List<Pista> pistas){

        this.nombre = nombre;
        this.pistas = pistas;
    }

    public Ciudad (String nombre){
        this.destinos = new ArrayList<>();
        this.pistas = new ArrayList<>();
        this.nombre = nombre;
        this.lugares = new ArrayList<>();

    }

    public String ciudad(){
        return this.nombre;
    }

    public Pista visitar(Lugar lugarSeleccionado, GradoDePolicia grado, Cronometro cronometro, Random dado) {

        return lugarSeleccionado.visitar(grado,this.pistas, cronometro,dado);

    }

    public void agregarDestino(String destino) {this.destinos.add(destino);}

    public void agregarPista(Pista pista){
        this.pistas.add(pista);
    }

    public void agregarLugar(String lugar) {
        boolean existe = this.lugares.contains(lugar);
        this.lugares = this.comprobarExistencia(existe,this.lugares,lugar);
    }

    public List<String> getListaLugares(){
        return this.lugares;
    }

    public List<String> getListaDestinos(){
        return this.destinos;
    }

    private List<String> comprobarExistencia(boolean existencia,List<String> lista,String elemento){
        if (!existencia){
            lista.add(elemento);
        }
        return lista;
    }

    public void setearPistasFalsas() {
        this.pistas.clear();
        for (String lugar: this.lugares) {
            this.pistas.add(new Pista(new Dificultad("Facil"),"No lo vimos por aqui",lugar));
            this.pistas.add(new Pista(new Dificultad("Medio"),"No lo vimos por aqui",lugar));
            this.pistas.add(new Pista(new Dificultad("Dificil"),"No lo vimos por aqui",lugar));
        }
    }
}
