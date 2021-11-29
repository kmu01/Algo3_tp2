package edu.fiuba.algo3.modelo;

public class Biblioteca implements LugarDeInteres{
    private Pista pista;
    public Biblioteca(){
        this.pista = new PistaFacil("pista1Biblioteca");
    }
    public String visitar(GradoDePolicia grado){
        return (this.pista.mostrarPista());
    }
}
