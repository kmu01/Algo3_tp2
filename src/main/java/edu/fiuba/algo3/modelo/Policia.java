package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.grados.GradoDePolicia;
import edu.fiuba.algo3.modelo.ordenDeArresto.OrdenDeArresto;
import edu.fiuba.algo3.modelo.ordenDeArresto.OrdenSinEmitir;

import java.util.List;
import java.util.Random;

public class Policia {

    private GradoDePolicia grado;
    private Sospechoso sospechoso;
    private int cantidadDeVecesAcuchillado;
    private OrdenDeArresto ordenDeArresto;

    public Policia(Sospechoso sospechoso, GradoDePolicia grado){
        this.grado = grado;
        this.sospechoso = sospechoso;
        this.cantidadDeVecesAcuchillado = 0;
        this.ordenDeArresto = new OrdenSinEmitir();
    }

    public void anotarCualidad(Cualidad cualidad){
        this.sospechoso.anotarCualidad(cualidad);
    }

    public void comprobarVictoria(RutaLadron rutaLadron){
        if(this.ordenDeArresto.emitida() && rutaLadron.estamosEnUltimaCiudad()){
            throw new JuegoGanadoException();
        }else if ((!this.ordenDeArresto.emitida()) && rutaLadron.estamosEnUltimaCiudad()){
            throw new NoTieneOrdenDeArrestoException();
        }
    }

    public Pista entrarEdificio(Lugar lugarSeleccionado, Cronometro cronometro, Random dado,Ciudad ciudadSiguiente) {
        this.dormir(cronometro);
        this.recibirCuchillazo(cronometro,dado);
        this.recibirHeridaDeBala(cronometro,dado);
        return ciudadSiguiente.visitar(lugarSeleccionado, this.grado, cronometro,dado);
    }
    public void viajar(Ciudad ciudadSeleccionada, Mapa mapa, Cronometro cronometro, Ciudad ciudadActual) {

        float distancia = mapa.calcularDistancia(ciudadSeleccionada, ciudadActual);
        this.grado.calcularTiempoDeViaje(distancia, cronometro);

    }

    private void recibirCuchillazo(Cronometro cronometro,Random dado) {
        int numero = dado.nextInt(15);
        if(numero == 5){
        cronometro.calcularTiempoDeCuchillazo(++this.cantidadDeVecesAcuchillado);
        throw new HasSidoAcuchilladoException();}
    }

    private void recibirHeridaDeBala(Cronometro cronometro,Random dado) {
        int numero = dado.nextInt(11);
        if(numero == 8){
        this.grado.calcularTiempoDeBalazo(cronometro);
        throw new HasSidoBaleadoException();}
    }

    public void dormir(Cronometro cronometro) {
        this.grado.calcularTiempoDurmiendo(cronometro);
    }

    public List<Ladron> buscarLadrones(Comisaria comisaria) {
        List<Ladron> ladrones = comisaria.buscarLadrones(this.sospechoso);
        this.emitirOrden(ladrones);
        return ladrones;
    }

    private void emitirOrden(List<Ladron> ladrones) {
        this.ordenDeArresto = ordenDeArresto.emitir(ladrones);
    }
}
