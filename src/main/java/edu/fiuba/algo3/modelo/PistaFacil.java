package edu.fiuba.algo3.modelo;

public class PistaFacil implements Pista{
    private String descripcion;
    public PistaFacil(String descripcion){
        this.descripcion = descripcion;
    }
    public String mostrarPista(){
        return (this.descripcion);
    }
    public boolean consultarEstado(GradoDePolicia grado){
        boolean validez;
        if(grado.consultarNivelDePistaDisponible() == "facil"){
            validez = true;
        }
        else{
            validez = false;
        }
        return validez;
    }
}
