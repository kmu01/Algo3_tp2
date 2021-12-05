package edu.fiuba.algo3.modelo;

public class ObjetoComun implements ObjetoRobado{

    private final int cantidadPaises = 4;
    private final String nombre;
    private Ciudad ciudad;

    public ObjetoComun(String nombre, Ciudad ciudad){

        this.nombre = nombre;
        this.ciudad = ciudad;

    }

    public ObjetoComun(String nombre){

        this.nombre = nombre;

    }

    public String mostrarNombre(){

        return this.nombre;

    }

}
