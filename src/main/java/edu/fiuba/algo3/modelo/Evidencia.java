package edu.fiuba.algo3.modelo;

public class Evidencia {
    private Pista pista;
    private Accion tiempoQueTardaEnEjecutarLaAccion;


    public Evidencia() {
        tiempoQueTardaEnEjecutarLaAccion = new Accion();
    }

    public void entradaAlEdificio(int cantDeVisitas,Pista pista) {
        this.pista = pista;
        this.tiempoQueTardaEnEjecutarLaAccion.calcularTiempoQueTardaEnRealizarLaAccion(cantDeVisitas);
    }
}
