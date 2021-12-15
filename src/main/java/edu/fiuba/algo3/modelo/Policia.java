package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.grados.GradoDePolicia;
import edu.fiuba.algo3.modelo.ordenDeArresto.OrdenDeArresto;
import edu.fiuba.algo3.modelo.ordenDeArresto.OrdenSinEmitir;

import java.util.List;
import java.util.Random;

public class Policia {

    private GradoDePolicia grado;
    private Sospechoso sospechoso;
    private Ciudad ciudadActual;
    private int cantidadDeVecesAcuchillado;
    private OrdenDeArresto ordenDeArresto;

    public Policia(Sospechoso sospechoso, GradoDePolicia grado,Ciudad ciudadInicial){

        this.grado = grado;
        this.sospechoso = sospechoso;
        this.ciudadActual = ciudadInicial;
        this.cantidadDeVecesAcuchillado = 0;
        this.ordenDeArresto = new OrdenSinEmitir();

    }

    public void anotarCualidad(Cualidad cualidad){
        this.sospechoso.anotarCualidad(cualidad);
    }

    public Pista entrarEdificio(Lugar lugarSeleccionado, Cronometro cronometro, Random dado) {
        return this.ciudadActual.visitar(lugarSeleccionado, this.grado, cronometro,dado);
    }
    public void viajar(Ciudad ciudadSeleccionada, Mapa mapa, Cronometro cronometro) {

        float distancia = mapa.calcularDistancia(ciudadSeleccionada,this.ciudadActual);
        this.grado.calcularTiempoDeViaje(distancia, cronometro);
        this.ciudadActual = ciudadSeleccionada;

    }

    public void recibirCuchillazo(Cronometro cronometro) {

        cronometro.calcularTiempoDeCuchillazo(++this.cantidadDeVecesAcuchillado);

    }

    public Ciudad obtenerCiudadActual(){
        return this.ciudadActual;
    }

    public void recibirHeridaDeBala(Cronometro cronometro) {
        this.grado.calcularTiempoDeBalazo(cronometro);
    }

    public void dormir(Cronometro cronometro) {

        this.grado.calcularTiempoDurmiendo(cronometro);

    }

    public List<Ladron> buscarLadrones(Comisaria comisaria) {
        List<Ladron> ladrones = comisaria.buscarLadrones(this.sospechoso);
        this.ordenDeArresto = this.emitirOrden(ladrones);
        return ladrones;
    }

    public boolean atrapar() {
        return (this.ordenDeArresto.emitida());
    }

    private OrdenDeArresto emitirOrden(List<Ladron> ladrones) {
        return ordenDeArresto.emitir(ladrones);
    }
}
