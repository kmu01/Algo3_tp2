package edu.fiuba.algo3.modelo;

public class ObjetoComun implements ObjetoRobado {
    private final int cantidadPaises = 4;
    private String nombre;
    public ObjetoComun(String nombre){
        this.nombre = nombre;
    }
    public String mostrarNombre(){
        return this.nombre;
    }
}
