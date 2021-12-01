package edu.fiuba.algo3.modelo;

public class PistaFacil implements Pista{
    private String descripcion;
    public PistaFacil(String descripcion){
        this.descripcion = descripcion;
    }
    public void mostrarPista(){
        System.out.println(this.descripcion);
    }

}
