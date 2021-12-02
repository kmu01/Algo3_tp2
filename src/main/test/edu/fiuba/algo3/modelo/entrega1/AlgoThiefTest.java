package edu.fiuba.algo3.modelo.entrega1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgoThiefTest {

    @Test
    public void elDetectiveComienzaEnMontrealYEntraAlBancoYPideUnaPista() {
        Ciudad ciudad = new Ciudad("Montreal");
        ciudad.agregarPista("facil","Se despliega la pista de banco","banco");
        Policia policia = new Policia("Tesoro nacional de Montreal",0, ciudad, new Mapa());

        policia.anotarGenero("Femenino");
        int tiempoDeEntrarEdificio = policia.entrarEdificio("banco");
        assertEquals(1, tiempoDeEntrarEdificio);
    }

    @Test
    public void elDetectiveComienzaEnMontrealYEntraAUnBancoYUnaBiblioteca() {
        Ciudad ciudad = new Ciudad("Montreal");
        ciudad.agregarPista("facil","Se despliega la pista de banco","banco");
        ciudad.agregarPista("facil","Se despliega la pista de biblioteca","biblioteca");
        Policia policia = new Policia("Tesoro nacional de Montreal",0, ciudad,new Mapa());
        int tiempoEsperado = policia.entrarEdificio("banco");
        assertEquals(1, tiempoEsperado);
        tiempoEsperado = policia.entrarEdificio("banco");
        assertEquals(2,tiempoEsperado);
        tiempoEsperado = policia.entrarEdificio("biblioteca");
        assertEquals(3,tiempoEsperado);

    }

       @Test
    public void elDetectiveViajaDeMontrealACiudadDeMexico(){
        Mapa mapa = new Mapa();
        mapa.agregarCiudad("Montreal",100,100);
        mapa.agregarCiudad("Ciudad de Mexico",700,250);
        Policia policia = new Policia("Tesoro nacional de Montreal",0, new Ciudad("Montreal"),mapa);
        policia.viajar(new Ciudad("Ciudad de Mexico"));

        assertEquals("Ciudad de Mexico",policia.mostrarCiudadActual());
    }

    @Test
    public void visita3VecesAeropuertoY55VecesPuerto() {

        Policia mockPolicia = Mockito.mock(Policia.class);

        mockPolicia.entrarEdificio("aeropuerto");

        mockPolicia.entrarEdificio("aeropuerto");

        mockPolicia.entrarEdificio("aeropuerto");
        verify(mockPolicia,times(3)).entrarEdificio("aeropuerto");

        for(int i = 0; i < 55; i++){

            mockPolicia.entrarEdificio("puerto");

        }
        verify(mockPolicia,times(55)).entrarEdificio("puerto");
    }
    @Test
    public void visita55VecesBancoYDevuelveExcepcion(){
        Ciudad ciudad = new Ciudad("Montreal");
        ciudad.agregarPista("facil","Se despliega la pista de banco","banco");
        Policia policia = new Policia("Tesoro nacional de Montreal",0, ciudad,new Mapa());
        try{
        for(int i = 0; i < 55; i++){

                policia.entrarEdificio("banco");


        }}catch(Exception e){
            assertThrows(Exception.class,()->{policia.entrarEdificio("banco");});
        }
    }

    @Test
    public void elDetectiveEsAcuchilladoYLuegoDuerme(){
        Policia policia = new Policia("Tesoro nacional de Montreal",0, new Ciudad("Montreal"),new Mapa());
        Ladron ladron = new Ladron("Tesoro nacional de Montreal");
        int restarTiempoAcuchillado = ladron.acuchillar(policia);
        assertEquals(1,restarTiempoAcuchillado);
        int restarHorasQueTardaEnDormir = policia.dormir();
        assertEquals(8,restarHorasQueTardaEnDormir);
    }
}