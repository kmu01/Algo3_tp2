package edu.fiuba.algo3.modelo;

public class Novato implements GradoDePolicia {
    private final int tiempoDeViaje = 900;
    private final String nivelDePistaDisponible = "facil";
    public Novato(){
    }

    @Override
    public int calcularTiempoDeViaje(int kilometros) {
        return kilometros/(this.tiempoDeViaje);
    }
    @Override
    public String consultarNivelDePistaDisponible(){
        return (this.nivelDePistaDisponible);
    }
}
