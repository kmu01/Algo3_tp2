package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladron extends MiembroDeBanda{
    public Ladron (String nombre, String genero, String hobbie, String cabello, String senia, String vehiculo,Ciudad ciudadFinal){

        this.nombre = nombre;
        this.cabello = cabello;
        this.hobbie = hobbie;
        this.genero = genero;
        this.senia = senia;
        this.vehiculo = vehiculo;
        this.ciudad = ciudadFinal;

    }

    public Ladron (String nombre, String genero, String hobbie, String cabello, String senia, String vehiculo){

        this.nombre = nombre;
        this.cabello = cabello;
        this.hobbie = hobbie;
        this.genero = genero;
        this.senia = senia;
        this.vehiculo = vehiculo;
        this.ciudad = null;

    }

    public Ciudad ciudad(){return (this.ciudad);}

    public void asignarObjetoRobado(ObjetoRobado objeto){
        this.objetoRobado = objeto;
        this.ciudad = objeto.ciudad();
    }

    public String nombre() {
        return (this.nombre);
    }

    List<String> crearListaDeAtributos(){
        List<String> listaAtributos = new ArrayList<>();
        listaAtributos.add(nombre);
        listaAtributos.add(cabello);
        listaAtributos.add(hobbie);
        listaAtributos.add(genero);
        listaAtributos.add(senia);
        listaAtributos.add(vehiculo);
        return listaAtributos;
    }

    public int esIgual(Sospechoso ladron) {

        int cantidadDeAtributosIguales = 0 ;
        cantidadDeAtributosIguales = (this.cabello.equals(ladron.cabello))?++cantidadDeAtributosIguales:cantidadDeAtributosIguales;
        cantidadDeAtributosIguales = (this.hobbie.equals(ladron.hobbie))?++cantidadDeAtributosIguales:cantidadDeAtributosIguales;
        cantidadDeAtributosIguales = (this.genero.equals(ladron.genero))?++cantidadDeAtributosIguales:cantidadDeAtributosIguales;
        cantidadDeAtributosIguales = (this.senia.equals((ladron.senia)))?++cantidadDeAtributosIguales:cantidadDeAtributosIguales;
        cantidadDeAtributosIguales = (this.vehiculo.equals(ladron.vehiculo))?++cantidadDeAtributosIguales:cantidadDeAtributosIguales;

        return cantidadDeAtributosIguales;
    }

    @Override
    public int hashCode() {return Objects.hash(this.cabello, this.hobbie, this.genero, this.senia, this.vehiculo);}
}

