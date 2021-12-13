package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.TiempoTerminadoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PartidaTests
{
    InicializadorDeArchivos inicializadorDeArchivos;
    Random mockDado;
    @BeforeEach
    public void setUp(){
        inicializadorDeArchivos = new InicializadorDeArchivos();
        mockDado = mock(Random.class);
        when(mockDado.nextInt(3)).thenReturn(1);
        when(mockDado.nextInt(7)).thenReturn(1);
    }

    @Test
    public void creoUnaPartidaYPidoDosPistaLuegoViajaAMexicoYDuerme() throws TiempoTerminadoException {
        Partida partida = null;
        try {
            partida = new Partida(inicializadorDeArchivos,mockDado);
            partida.nuevoCaso(3);
            Pista pista = partida.entrarEdificio("Banco");

            assertEquals("Cambio sus monedas a pesos argentinos",pista.descripcion());

            pista = partida.entrarEdificio("Banco");

            assertEquals("Cambio sus monedas a pesos argentinos",pista.descripcion());

            partida.viajar("Ciudad de Mexico");

            assertEquals("Monday, 17 Hs.",partida.hora());
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @Test

    public void buscoSospechososYMeDevuelveExcepcion(){


        try {
            Partida partida = null;
            partida = new Partida(inicializadorDeArchivos,mockDado);
            partida.nuevoCaso(6);
            partida.anotarCualidad("Femenino");
            partida.anotarCualidad("Marron");
            partida.buscarLadrones();

            Partida finalPartida = partida;
            assertThrows(TiempoTerminadoException.class,()->{
                finalPartida.entrarEdificio("banco");});
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void entraAEdificioYEsAcuchillado(){
        when(mockDado.nextInt(7)).thenReturn(5);
        Partida partida = null;
        try {
            partida = new Partida(inicializadorDeArchivos,mockDado);
            partida.nuevoCaso(6);
            partida.entrarEdificio("Bolsa");
            assertEquals("Monday, 10 Hs.",partida.hora());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

