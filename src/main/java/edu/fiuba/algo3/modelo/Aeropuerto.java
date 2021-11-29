package edu.fiuba.algo3.modelo;

public class Aeropuerto implements LugarDeInteres{
    private Pista pista;
    public Aeropuerto(){
        this.pista = new PistaFacil("pista1aeropuerto");
    }
    public String visitar(GradoDePolicia grado){
        return (this.pista.mostrarPista());
    }
}
