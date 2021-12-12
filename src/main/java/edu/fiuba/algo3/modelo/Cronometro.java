package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.GameOverException;

public class Cronometro {

    private Tiempo tiempo;

    public Cronometro(Tiempo tiempo){

        this.tiempo = tiempo;

    }

    public void calcularTiempoDeViaje(float distancia, int tiempoDeViaje) throws GameOverException {

        this.tiempo.agregarHoras((int) Math.floor(distancia/(tiempoDeViaje)));

    }

    public void calcularTiempoDeCuchillazo(int cantidadDeVecesAcuchillado) throws GameOverException {

        this.tiempo.agregarHoras(cantidadDeVecesAcuchillado == 1 ? 2 : 1);

    }

    public void calcularTiempoDurmiendo(int tiempoDeDescanso) throws GameOverException {
        this.tiempo.debeDormir(tiempoDeDescanso);
    }

    public void calcularTiempoEnObtenerLaPista(int cantidadDeVisitas) throws GameOverException {
        switch (cantidadDeVisitas){
            case 1:
                this.tiempo.agregarHoras(1);
                break;
            case 2:
                this.tiempo.agregarHoras(2);
                break;
            default:
                this.tiempo.agregarHoras(3);
        }

    }

    public void calcularTiempoDeBalazo(int tiempoDeHeridaDeBala) throws GameOverException {
        this.tiempo.agregarHoras(tiempoDeHeridaDeBala);
    }
}
