package edu.fiuba.algo3.modelo;

public class ObjetoComun implements ObjetoRobado{

    private final int cantidadPaises = 4;
    private final String nombre;
    private Ciudad ciudad;
    private final String rareza = "comun";

    public ObjetoComun(String nombre, Ciudad ciudad){

        this.nombre = nombre;
        this.ciudad = ciudad;

    }

    public ObjetoComun(String nombre){

        this.nombre = nombre;

    }
    public int cantidadPaises(){return this.cantidadPaises;}

    public String mostrarNombre(){

        return this.nombre;

    }
    @Override
    public Ciudad ciudad(){
        return this.ciudad;
    }

    @Override
    public String rareza(){
        return this.rareza;
    }
}
