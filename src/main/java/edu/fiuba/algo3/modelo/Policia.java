package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.grados.GradoDePolicia;

import java.util.List;
import java.util.Random;

public class Policia {

    private GradoDePolicia grado;
    private Sospechoso sospechoso;
    private Ciudad ciudadActual;
    private int cantidadDeVecesAcuchillado;

    public Policia(Sospechoso sospechoso, GradoDePolicia grado,Ciudad ciudadInicial){

        this.grado = grado;
        this.sospechoso = sospechoso;
        this.ciudadActual = ciudadInicial;
        this.cantidadDeVecesAcuchillado = 0;

    }

    public void anotarCualidad(Cualidad cualidad){
        this.sospechoso.anotarCualidad(cualidad);
    }

    public Pista entrarEdificio(Lugar lugarSeleccionado, Cronometro cronometro, Random dado) throws GameOverException {
        return this.ciudadActual.visitar(lugarSeleccionado, this.grado, cronometro,dado);
    }
    public void viajar(Ciudad ciudadSeleccionada, Mapa mapa, Cronometro cronometro) throws GameOverException {


        float distancia = mapa.calcularDistancia(ciudadSeleccionada,this.ciudadActual);
        this.grado.calcularTiempoDeViaje(distancia, cronometro);
        this.ciudadActual = ciudadSeleccionada;

    }

    public void recibirCuchillazo(Cronometro cronometro) throws GameOverException {

        cronometro.calcularTiempoDeCuchillazo(++this.cantidadDeVecesAcuchillado);

    }
    public void recibirHeridaDeBala(Cronometro cronometro) throws GameOverException {
        this.grado.calcularTiempoDeBalazo(cronometro);
    }

    public void dormir(Cronometro cronometro) throws GameOverException {

        this.grado.calcularTiempoDurmiendo(cronometro);

    }
    public List<Ladron> cargarDatos(Comisaria comisaria){
        return comisaria.cargarDatos(this.sospechoso);
    }

    public boolean atrapar(Ladron ladron,int cantidadDePaisesVisitados) {
        return ladron.esAtrapado(this.ciudadActual,cantidadDePaisesVisitados);
    }
}
