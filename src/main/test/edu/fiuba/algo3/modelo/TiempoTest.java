package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TiempoTest {
    @Test
    public void creoInstanciaTiempoYPidoFechaActual(){
        Tiempo t = new Tiempo();
        String fechaEsperada = "lunes, 07 Hs.";
        assertEquals(fechaEsperada,t.tiempoFormateado());
    }

    @Test
    public void agregoTiempoYPidoFechaActual() throws GameOverException {
        Tiempo t = new Tiempo();
        t.agregarHoras(10);
        String fechaEsperada = "lunes, 17 Hs.";
        assertEquals(fechaEsperada,t.tiempoFormateado());
    }

    @Test
    public void agrego24HsYPidoFechaActual() throws GameOverException {
        Tiempo t = new Tiempo();
        t.agregarHoras(24);
        String fechaEsperada = "martes, 07 Hs.";
        assertEquals(fechaEsperada,t.tiempoFormateado());
    }

    @Test
    public void avanzoMuyCercaDelFinalYPidoFecha() throws GameOverException {
        Tiempo t = new Tiempo();
        t.agregarHoras(153);
        String fechaEsperada = "domingo, 16 Hs.";
        assertEquals(fechaEsperada,t.tiempoFormateado());
    }

    @Test
    public void mePasoDeTiempoYDevuelveExcepcion(){
        Tiempo t = new Tiempo();
        assertThrows(GameOverException.class, () -> t.agregarHoras(155));
    }
}
