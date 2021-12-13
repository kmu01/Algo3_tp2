package edu.fiuba.algo3.modelo.entrega1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.GameOverException;
import edu.fiuba.algo3.modelo.grados.Detective;
import edu.fiuba.algo3.modelo.grados.Investigador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasosDeUsoTests {

    List<Pista> pistas = new ArrayList<>();
    Ciudad ciudad;
    Tiempo tiempo;
    Cronometro cronometro;

    @BeforeEach
    public void setUp(){

        List<String> nombresDeLugares = new ArrayList<>();
        nombresDeLugares.add("banco");
        nombresDeLugares.add("bolsa");
        nombresDeLugares.add("biblioteca");
        nombresDeLugares.add("puerto");
        nombresDeLugares.add("aeropuerto");

        HashMap<String, String> descripciones = new HashMap<>();
        descripciones.put("banco", "Se despliega la pista de banco");
        descripciones.put("bolsa", "Se despliega la pista de bolsa");
        descripciones.put("biblioteca", "Se despliega la pista de biblioteca");
        descripciones.put("puerto", "Se despliega la pista de puerto");
        descripciones.put("aeropuerto", "Se despliega la pista de aeropuerto");

        descripciones.forEach((lugar, description) -> pistas.add(new Pista(new Dificultad("Medio"), description, lugar)));

        tiempo = new Tiempo();
        cronometro = new Cronometro(tiempo);

        ciudad = new Ciudad("Montreal", pistas);

    }

    @Test
    public void elDetectiveComienzaEnMontrealYEntraAlBancoYPideUnaPista() {
        Random mockDado = mock(Random.class);
        when( mockDado.nextInt(3)).thenReturn(1);
        Policia policia = new Policia(new Sospechoso(), new Investigador(), ciudad);

        policia.anotarCualidad(new Cualidad("Femenino"));

        Pista pista = null;

        try {
            pista = policia.entrarEdificio(new Lugar("banco"), cronometro,mockDado);
        } catch (GameOverException e) {
            e.printStackTrace();
        }

        assertEquals("Se despliega la pista de banco", pista.descripcion());
        assertEquals(1,tiempo.tiempoTranscurrido());

    }

    @Test
    public void elDetectiveComienzaEnMontrealYEntraAUnBancoYUnaBiblioteca() {
        Random mockDado = mock(Random.class);
        when( mockDado.nextInt(3)).thenReturn(1);
        Policia policia = new Policia(new Sospechoso(), new Detective(), ciudad);

        Pista pistaPrimerBanco = null;
        try {
            pistaPrimerBanco = policia.entrarEdificio(new Lugar("banco"), cronometro,mockDado);
        } catch (GameOverException e) {
            e.printStackTrace();
        }

        assertEquals("Se despliega la pista de banco", pistaPrimerBanco.descripcion());
        Pista pistaSegundoBanco = null;

        try {
            pistaSegundoBanco = policia.entrarEdificio(new Lugar("banco"), cronometro,mockDado);
        } catch (GameOverException e) {
            e.printStackTrace();
        }
        assertEquals("Se despliega la pista de banco", pistaSegundoBanco.descripcion());
        assertEquals(3,tiempo.tiempoTranscurrido());
        Pista pistaBliblioteca = null;
        try {
            pistaBliblioteca = policia.entrarEdificio(new Lugar("biblioteca"), cronometro,mockDado);
        } catch (GameOverException e) {
            e.printStackTrace();
        }

        assertEquals("Se despliega la pista de biblioteca", pistaBliblioteca.descripcion());
        assertEquals(4,tiempo.tiempoTranscurrido());

    }

    @Test
    public void elDetectiveViajaDeMontrealACiudadDeMexico() throws GameOverException {

        Mapa mapa = new Mapa();
        Ciudad actual = new Ciudad("Montreal");
        Ciudad destino = new Ciudad("Ciudad de Mexico");
        mapa.agregarCiudad(actual,20,15);
        mapa.agregarCiudad(destino,7, 2.5F);

        Policia policia = new Policia(new Sospechoso(), new Detective(), actual);
        policia.viajar(destino, mapa, cronometro);

        assertEquals((1),tiempo.tiempoTranscurrido());

    }

    @Test
    public void visita3VecesAeropuertoY55VecesPuerto() {
        Random mockDado = mock(Random.class);
        when( mockDado.nextInt(3)).thenReturn(1);
        Policia policia = new Policia(new Sospechoso(), new Detective(), ciudad);

        for(int i = 0; i < 3; i++){

            try {
                policia.entrarEdificio(new Lugar("aeropuerto"), cronometro,mockDado);
            } catch (GameOverException e) {
            }

            //assertFalse(tiempo.finalizado());

        }

        for(int i = 0; i < 55; i++){
            try {
                policia.entrarEdificio(new Lugar("puerto"), cronometro,mockDado);
            } catch (GameOverException e) {
            }


        }

        //assertTrue(tiempo.finalizado());

    }

    @Test
    public void elDetectiveEsAcuchilladoYLuegoDuerme(){

        Policia policia = new Policia(new Sospechoso(), new Detective(), ciudad);
        try {
            policia.recibirCuchillazo(cronometro);
        } catch (GameOverException e) {
            e.printStackTrace();
        }
        assertEquals(2, tiempo.tiempoTranscurrido());
        try {
            policia.dormir(cronometro);
        } catch (GameOverException e) {
            e.printStackTrace();
        }
        assertEquals(2, tiempo.tiempoTranscurrido());

    }
}