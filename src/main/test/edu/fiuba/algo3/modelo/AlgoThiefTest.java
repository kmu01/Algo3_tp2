package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgoThiefTest {
    private Policia policia;

    @Test
    public void elDetectiveComienzaEnMontrealYEntraAlBancoYPideUnaPista() {
        Policia policia = new Policia("Tesoro nacional de Montreal",0, new Ciudad("Montreal"));
        policia.anotarGenero("Femenino");
        String pista = policia.entrarEdificio("banco");
        assertEquals("pistaNovatoBanco", pista);
    }

    @Test
    public void elDetectiveComienzaEnMontrealYEntraAUnBancoYUnaBiblioteca() {
        Policia policia = new Policia("Tesoro nacional de Montreal",0, new Ciudad("Montreal"));
        String pista = policia.entrarEdificio("banco");
        assertEquals("pistaNovatoBanco", pista);
        pista = policia.entrarEdificio("banco");
        assertEquals("pistaNovatoBanco",pista);
        pista = policia.entrarEdificio("biblioteca");
        assertEquals("pistaNovatoBiblioteca",pista);

    }


       @Test
    public void elDetectiveViajaDeMontrealACiudadDeMexico(){
        Policia policia = new Policia("Tesoro nacional de Montreal",0, new Ciudad("Montreal"));
        policia.viajar(new Ciudad("Ciudad de Mexico"));
        assertEquals("Ciudad de Mexico",policia.mostrarCiudadActual());

    }

    @Test

    public void visita3VecesAeropuertoY55VecesPuerto(){
        Policia policia = new Policia("Tesoro nacional de Montreal",0, new Ciudad("Montreal"));
        String pista = policia.entrarEdificio("aeropuerto");
        assertEquals("pista1aeropuerto",pista);
        pista = policia.entrarEdificio("aeropuerto");
        assertEquals("pista1aeropuerto",pista);
        pista = policia.entrarEdificio("puerto");
        assertEquals("pistaNovatoPuerto",pista);

    }

    @Test
    public void elDetectiveEsAcuchilladoYLuegoDuerme(){
        Policia policia = new Policia("Tesoro nacional de Montreal",0, new Ciudad("Montreal"));
        Ladron ladron = new Ladron("Tesoro nacional de Montreal", policia.obtenerArrestos());
        int restarTiempoAcuchillado = ladron.acuchillar(policia);
        assertEquals(1,restarTiempoAcuchillado);
        int restarHorasQueTardaEnDormir = policia.dormir();
        assertEquals(8,restarHorasQueTardaEnDormir);
    }
}