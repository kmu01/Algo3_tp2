package edu.fiuba.algo3.modelo;

public class Puerto implements LugarDeInteres{
    private Pista pista;
    public Puerto(){
        this.pista = new PistaFacil("pista1puerto");
    }
    public String visitar(GradoDePolicia grado){
        return (this.pista.mostrarPista());
    }
}
