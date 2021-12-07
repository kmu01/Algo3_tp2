package edu.fiuba.algo3.modelo.entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlgoThiefTest {

    @Test
    public void losDatosSeCarganCorrectamente() {
        Partida partida = new Partida();
    }

    @Test
    public void elDetectiveEsAcuchilladoYLuegoDuerme(){
        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);
        Ciudad ciudad = new Ciudad();
        Policia policia = new Policia(new Sospechoso(), new Detective(), ciudad);

        policia.recibirCuchillazo(cronometro);
        assertEquals(2, tiempo.tiempoRestante());
        policia.dormir(cronometro);
        assertEquals(10, tiempo.tiempoRestante());

    }

    @Test
    public void investigadorTomaCasoYViajaDeMontrealAMexico(){

        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);
        Mapa mapa = new Mapa();
        Ciudad actual = new Ciudad("Montreal");
        Ciudad destino = new Ciudad("Ciudad de Mexico");
        mapa.agregarCiudad(actual,2000,1500);
        mapa.agregarCiudad(destino,700,250);

        Policia policia = new Policia(new Sospechoso(), new Detective(), actual);
        policia.viajar(destino, mapa, cronometro);

        assertEquals("Ciudad de Mexico",policia.mostrarCiudadActual());
        assertEquals((1),tiempo.tiempoRestante());

    }

    @Test
    public void cargarInformacionRecopiladaYBuscarSospechosos(){

        Partida partida = new Partida();
        partida.nuevoCaso(2);
        partida.anotarGenero("Femenino");

        assertEquals(5,partida.emitirOrderDeArresto().size());

    }

    @Test
    public void intentaAtraparSospechosoSinLaOrden(){
        Partida partida = new Partida();
        partida.nuevoCaso(2);
        partida.anotarGenero("Femenino");
        partida.emitirOrderDeArresto();

        assertFalse(partida.atrapar());
    }



}