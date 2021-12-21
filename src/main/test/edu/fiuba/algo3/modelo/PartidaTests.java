package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.HasSidoAcuchilladoException;
import edu.fiuba.algo3.modelo.excepciones.TiempoTerminadoException;
import edu.fiuba.algo3.modelo.tablero.InicializadorDeArchivos;
import edu.fiuba.algo3.modelo.tablero.Partida;
import edu.fiuba.algo3.modelo.tablero.Pista;
import edu.fiuba.algo3.modelo.tablero.RutaLadron;
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
        when(mockDado.nextInt(11)).thenReturn(2);
        when(mockDado.nextInt(10)).thenReturn(1);
        when(mockDado.nextInt(4)).thenReturn(1);
    }

    @Test
    public void creoUnaPartidaYPidoDosPistasLuegoViajaAMexicoYDuerme() throws TiempoTerminadoException {
        try {
            Partida partida = new Partida(inicializadorDeArchivos, mockDado, new RutaLadron());
            partida.nuevoCaso(3);
            Pista pista = partida.entrarEdificio("Banco");

            assertEquals("Intercambió sus divisas al Yuan. Es pelirrojo", pista.descripcion());

            pista = partida.entrarEdificio("Banco");

            assertEquals("Intercambió sus divisas al Yuan. Es pelirrojo", pista.descripcion());

            partida.viajar("Ciudad de Mexico");

            assertEquals("Tuesday, 01 Hs.",partida.hora());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void entraAEdificioYEsAcuchillado(){
        when(mockDado.nextInt(15)).thenReturn(5);
        try {
            Partida partida = new Partida(inicializadorDeArchivos,mockDado,new RutaLadron());
            partida.nuevoCaso(6);
            assertThrows(HasSidoAcuchilladoException.class, () -> partida.entrarEdificio("Bolsa"));
            assertEquals("Monday, 09 Hs.",partida.hora());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

