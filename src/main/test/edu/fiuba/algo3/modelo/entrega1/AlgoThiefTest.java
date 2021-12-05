package edu.fiuba.algo3.modelo.entrega1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlgoThiefTest {

    List<Pista> pistas = new ArrayList<Pista>();
    Ciudad ciudad;
    Tiempo tiempo;
    Cronometro cronometro;

    @BeforeEach
    public void setUp(){

        List<String> nombresDeLugares = new ArrayList<String>();
        nombresDeLugares.add("banco");
        nombresDeLugares.add("bolsa");
        nombresDeLugares.add("biblioteca");
        nombresDeLugares.add("puerto");
        nombresDeLugares.add("aeropuerto");

        HashMap<String, String> descripciones = new HashMap<String, String>();
        descripciones.put("banco", "Se despliega la pista de banco");
        descripciones.put("bolsa", "Se despliega la pista de bolsa");
        descripciones.put("biblioteca", "Se despliega la pista de biblioteca");
        descripciones.put("puerto", "Se despliega la pista de puerto");
        descripciones.put("aeropuerto", "Se despliega la pista de aeropuerto");

        descripciones.forEach((lugar, description) -> pistas.add(new Pista(new Medio(), description, lugar)));

        tiempo = new Tiempo();
        cronometro = new Cronometro(tiempo);

        ciudad = new Ciudad("Montreal", pistas);

    }

    @Test
    public void elDetectiveComienzaEnMontrealYEntraAlBancoYPideUnaPista() {

        Policia policia = new Policia(new Sospechoso(new ObjetoComun("Tesoro de Montreal")), new Investigador(), ciudad);

        policia.anotarGenero("Femenino");

        Pista pista = policia.entrarEdificio(new Lugar("banco"), cronometro);
        assertEquals("Se despliega la pista de banco", pista.descripcion());
        assertEquals(1,tiempo.tiempoRestante());

    }

    @Test
    public void elDetectiveComienzaEnMontrealYEntraAUnBancoYUnaBiblioteca() {

        Policia policia = new Policia(new Sospechoso(new ObjetoComun("Tesoro de Montreal")), new Detective(), ciudad);

        Pista pistaPrimerBanco = policia.entrarEdificio(new Lugar("banco"), cronometro);
        assertEquals("Se despliega la pista de banco", pistaPrimerBanco.descripcion());
        Pista pistaSegundoBanco = policia.entrarEdificio(new Lugar("banco"), cronometro);
        assertEquals("Se despliega la pista de banco", pistaSegundoBanco.descripcion());
        assertEquals(3,tiempo.tiempoRestante());
        Pista pistaBliblioteca = policia.entrarEdificio(new Lugar("biblioteca"), cronometro);
        assertEquals("Se despliega la pista de biblioteca", pistaBliblioteca.descripcion());
        assertEquals(4,tiempo.tiempoRestante());

    }

    @Test
    public void elDetectiveViajaDeMontrealACiudadDeMexico(){

        Mapa mapa = new Mapa();
        mapa.agregarCiudad("Montreal",2000,1500);
        mapa.agregarCiudad("Ciudad de Mexico",700,250);

        Policia policia = new Policia(new Sospechoso(new ObjetoComun("Tesoro de Montreal")), new Detective(), ciudad);
        policia.viajar(new Ciudad("Ciudad de Mexico"), mapa, cronometro);

        assertEquals("Ciudad de Mexico",policia.mostrarCiudadActual());
        assertEquals((1),tiempo.tiempoRestante());

    }

    @Test
    public void visita3VecesAeropuertoY55VecesPuerto() {

        Policia policia = new Policia(new Sospechoso(new ObjetoComun("Tesoro de Montreal")), new Detective(), ciudad);

        for(int i = 0; i < 3; i++){

            policia.entrarEdificio(new Lugar("aeropuerto"), cronometro);
            assertFalse(tiempo.finalizado());

        }

        for(int i = 0; i < 55; i++){

            policia.entrarEdificio(new Lugar("puerto"), cronometro);

        }

        assertTrue(tiempo.finalizado());

    }

    @Test
    public void elDetectiveEsAcuchilladoYLuegoDuerme(){

        Policia policia = new Policia(new Sospechoso(new ObjetoComun("Tesoro de Montreal")), new Detective(), ciudad);

        policia.recibirCuchillazo(cronometro);
        assertEquals(2, tiempo.tiempoRestante());
        policia.dormir(cronometro);
        assertEquals(10, tiempo.tiempoRestante());

    }
}