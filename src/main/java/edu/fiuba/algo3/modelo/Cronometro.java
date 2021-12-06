package edu.fiuba.algo3.modelo;

public class Cronometro {

    private Tiempo tiempo;

    public Cronometro(Tiempo tiempo){

        this.tiempo = tiempo;

    }

    public void calcularTiempoDeViaje(float distancia, int tiempoDeViaje) {

        this.tiempo.agregarTiempo((int) Math.floor(distancia/(tiempoDeViaje)));

    }

    public void calcularTiempoDeCuchillazo(int cantidadDeVecesAcuchillado) {

        this.tiempo.agregarTiempo(cantidadDeVecesAcuchillado == 1 ? 2 : 1);

    }

    public void calcularTiempoDurmiendo(int tiempoDeDescanso) {

        this.tiempo.agregarTiempo(tiempoDeDescanso);

    }

    public void calcularTiempoEnObtenerLaPista(int cantidadDeVisitas) {

        if (cantidadDeVisitas == 1){
            this.tiempo.agregarTiempo(1);
        }
        else if  (cantidadDeVisitas == 2){
            this.tiempo.agregarTiempo(2);
        }
        else {
            this.tiempo.agregarTiempo(3);
        }
    }

    public void calcularTiempoDeBalazo(int tiempoDeHeridaDeBala) {
        this.tiempo.agregarTiempo(tiempoDeHeridaDeBala);
    }
}
