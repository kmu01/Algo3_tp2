package edu.fiuba.algo3.modelo;

public class ObjetoMuyValioso implements ObjetoRobado {

    private final int cantidadPaises = 7;
    private final String nombre;
    private Ciudad ciudad;

    public ObjetoMuyValioso(String nombre, Ciudad ciudad){

        this.nombre = nombre;
        this.ciudad = ciudad;

    }

    public ObjetoMuyValioso(String nombre){

        this.nombre = nombre;

    }

    public String mostrarNombre(){

        return this.nombre;

    }
}
