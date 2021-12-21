package edu.fiuba.algo3.modelo.entrega1;

import edu.fiuba.algo3.modelo.comisaria.Cualidad;
import edu.fiuba.algo3.modelo.comisaria.Policia;
import edu.fiuba.algo3.modelo.comisaria.Sospechoso;
import edu.fiuba.algo3.modelo.excepciones.HasSidoAcuchilladoException;
import edu.fiuba.algo3.modelo.excepciones.TiempoTerminadoException;
import edu.fiuba.algo3.modelo.grados.Detective;
import edu.fiuba.algo3.modelo.grados.Investigador;
import edu.fiuba.algo3.modelo.tablero.Dificultad;
import edu.fiuba.algo3.modelo.tablero.Pista;
import edu.fiuba.algo3.modelo.ubicacion.*;
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
    Ciudad ciudadSiguiente;

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

        ciudad = new Ciudad("Montreal");
        ciudadSiguiente = new Ciudad("Ciudad de Mexico", pistas);

    }

    @Test
    public void elDetectiveComienzaEnMontrealYEntraAlBancoYPideUnaPista() {
        Random mockDado = mock(Random.class);
        when( mockDado.nextInt(3)).thenReturn(1);
        Policia policia = new Policia(new Sospechoso(), new Investigador());

        policia.anotarCualidad(new Cualidad("Femenino"));

        Pista pista = null;

        try {
            pista = policia.entrarEdificio(new Lugar("banco"), cronometro,mockDado, ciudadSiguiente);
        } catch (TiempoTerminadoException e) {
            e.printStackTrace();
        }

        assertEquals("Se despliega la pista de banco ", pista.descripcion());
        assertEquals(1,tiempo.tiempoTranscurrido());

    }

    @Test
    public void elDetectiveComienzaEnMontrealYEntraAUnBancoYUnaBiblioteca() {
        Random mockDado = mock(Random.class);
        when( mockDado.nextInt(3)).thenReturn(1);
        Policia policia = new Policia(new Sospechoso(), new Detective());

        Pista pistaPrimerBanco = null;
        try {
            pistaPrimerBanco = policia.entrarEdificio(new Lugar("banco"), cronometro, mockDado, ciudadSiguiente);
        } catch (TiempoTerminadoException e) {
            e.printStackTrace();
        }

        assertEquals("Se despliega la pista de banco ", pistaPrimerBanco.descripcion());
        Pista pistaSegundoBanco = null;

        try {
            pistaSegundoBanco = policia.entrarEdificio(new Lugar("banco"), cronometro,mockDado, ciudadSiguiente);
        } catch (TiempoTerminadoException e) {
            e.printStackTrace();
        }
        assertEquals("Se despliega la pista de banco ", pistaSegundoBanco.descripcion());
        assertEquals(3,tiempo.tiempoTranscurrido());
        Pista pistaBliblioteca = null;
        try {
            pistaBliblioteca = policia.entrarEdificio(new Lugar("biblioteca"), cronometro,mockDado, ciudadSiguiente);
        } catch (TiempoTerminadoException e) {
            e.printStackTrace();
        }

        assertEquals("Se despliega la pista de biblioteca ", pistaBliblioteca.descripcion());
        assertEquals(4,tiempo.tiempoTranscurrido());

    }

    @Test
    public void elDetectiveViajaDeMontrealACiudadDeMexico() throws TiempoTerminadoException {

        Mapa mapa = new Mapa();
        Ciudad actual = new Ciudad("Montreal");
        Ciudad destino = new Ciudad("Ciudad de Mexico");
        mapa.agregarCiudad(actual,20,15);
        mapa.agregarCiudad(destino,7, 2.5F);

        Policia policia = new Policia(new Sospechoso(), new Detective());
        policia.viajar(destino, mapa, cronometro,actual);

        assertEquals((1),tiempo.tiempoTranscurrido());

    }

    @Test
    public void visita3VecesAeropuertoY55VecesPuerto() {
        Random mockDado = mock(Random.class);
        when( mockDado.nextInt(3)).thenReturn(1);
        Policia policia = new Policia(new Sospechoso(), new Detective());

        for(int i = 0; i < 3; i++){

            try {
                policia.entrarEdificio(new Lugar("aeropuerto"), cronometro,mockDado, ciudadSiguiente);
            } catch (TiempoTerminadoException e) {
            }

        }

        for(int i = 0; i < 55; i++){
            try {
                policia.entrarEdificio(new Lugar("puerto"), cronometro,mockDado, ciudadSiguiente);
            } catch (TiempoTerminadoException e) {
            }


        }

    }

    @Test
    public void elDetectiveEsAcuchilladoYLuegoDuerme(){

        Random mockDado = mock(Random.class);
        Policia policia = new Policia(new Sospechoso(), new Detective());
        try {
            when(mockDado.nextInt(15)).thenReturn(5);
            assertThrows(HasSidoAcuchilladoException.class, () -> {policia.entrarEdificio(new Lugar("Banco"), cronometro, mockDado,ciudadSiguiente);
                });
        } catch (TiempoTerminadoException e) {
            e.printStackTrace();
        }
        assertEquals(2, tiempo.tiempoTranscurrido());
        try {
            policia.dormir(cronometro);
        } catch (TiempoTerminadoException e) {
            e.printStackTrace();
        }
        assertEquals(2, tiempo.tiempoTranscurrido());

    }
}