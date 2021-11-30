package edu.fiuba.algo3.modelo.entrega1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlgoThiefTest {
    private Policia policia;

    @Test
    public void elDetectiveComienzaEnMontrealYEntraAlBancoYPideUnaPista() {
        Ciudad ciudad = new Ciudad("Montreal");
        ciudad.agregarPista("facil","hola","banco");
        Policia policia = new Policia("Tesoro nacional de Montreal",0, ciudad, new Mapa());

        policia.anotarGenero("Femenino");
        int tiempoDeEntrarEdificio = policia.entrarEdificio("banco");
        assertEquals(1, tiempoDeEntrarEdificio);
    }

    @Test
    public void elDetectiveComienzaEnMontrealYEntraAUnBancoYUnaBiblioteca() {
        Ciudad ciudad = new Ciudad("Montreal");
        ciudad.agregarPista("facil","aa","banco");
        ciudad.agregarPista("facil","aas","biblioteca");
        Policia policia = new Policia("Tesoro nacional de Montreal",0, ciudad,new Mapa());
        int tiempo = policia.entrarEdificio("banco");
        assertEquals(1, tiempo);
        tiempo = policia.entrarEdificio("banco");
        assertEquals(2,tiempo);
        tiempo = policia.entrarEdificio("biblioteca");
        assertEquals(3,tiempo);

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

    public void visita3VecesAeropuertoY55VecesPuerto() throws Exception {
        Tiempo tiempo = new Tiempo();
        Ciudad ciudad = new Ciudad("Montreal");
        ciudad.agregarPista("facil","da","aeropuerto");
        ciudad.agregarPista("facil","das","puerto");
        Policia policia = new Policia("Tesoro nacional de Montreal",0, ciudad,new Mapa());
        int tiempoQueSeVaADescontar = policia.entrarEdificio("aeropuerto");
        assertEquals(1,tiempoQueSeVaADescontar);
        tiempoQueSeVaADescontar = policia.entrarEdificio("aeropuerto");
        assertEquals(2,tiempoQueSeVaADescontar);
        tiempoQueSeVaADescontar = policia.entrarEdificio("aeropuerto");
        assertEquals(3,tiempoQueSeVaADescontar);

        for(int i = 0; i < 55; i++){
            tiempoQueSeVaADescontar = policia.entrarEdificio("puerto");
            try{
                tiempo.agregarTiempo(tiempoQueSeVaADescontar);
            }catch(Exception e){
                tiempoQueSeVaADescontar = 168;
            }
        }
        assertEquals(168,tiempoQueSeVaADescontar);
        /*assertThrows(Exception.class, () -> (for(int i = 0; i < 55; i++){
            tiempoQueSeVaADescontar = policia.entrarEdificio("puerto");
            tiempo.agregarTiempo(tiempoQueSeVaADescontar);

        }))*/
    }

    @Test
    public void elDetectiveEsAcuchilladoYLuegoDuerme(){
        Policia policia = new Policia("Tesoro nacional de Montreal",0, new Ciudad("Montreal"),new Mapa());
        Ladron ladron = new Ladron("Tesoro nacional de Montreal", policia.obtenerArrestos());
        int restarTiempoAcuchillado = ladron.acuchillar(policia);
        assertEquals(1,restarTiempoAcuchillado);
        int restarHorasQueTardaEnDormir = policia.dormir();
        assertEquals(8,restarHorasQueTardaEnDormir);
    }
}