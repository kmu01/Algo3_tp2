package edu.fiuba.algo3.modelo;

public class ObjetoValioso implements ObjetoRobado {

    private final int cantidadPaises = 5;
    private final String nombre;
    private Ciudad ciudad;

    public ObjetoValioso(String nombre, Ciudad ciudad){

        this.nombre = nombre;
        this.ciudad = ciudad;

    }

    public ObjetoValioso(String nombre){

        this.nombre = nombre;

    }

    public String mostrarNombre(){

        return this.nombre;

    }
}
