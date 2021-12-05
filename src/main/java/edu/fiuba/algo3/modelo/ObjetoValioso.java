package edu.fiuba.algo3.modelo;

public class ObjetoValioso implements ObjetoRobado {

    private final int cantidadPaises = 5;
    private final String nombre;

    public ObjetoValioso(String nombre){

        this.nombre = nombre;

    }

    public String mostrarNombre(){

        return this.nombre;

    }
}
