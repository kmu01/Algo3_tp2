package edu.fiuba.algo3.modelo;

public class ObjetoValioso implements ObjetoRobado {

    private final int cantidadPaises = 5;
    private final String nombre;
    private Ciudad ciudad;
    private final String rareza = "valioso";

    public ObjetoValioso(String nombre, Ciudad ciudad){

        this.nombre = nombre;
        this.ciudad = ciudad;

    }


    public String mostrarNombre(){

        return this.nombre;

    }
    public int cantidadPaises(){return this.cantidadPaises;}

    @Override
    public Ciudad ciudad(){
        return this.ciudad;
    }

    @Override
    public String rareza(){
        return this.rareza;
    }
}
