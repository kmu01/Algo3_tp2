package edu.fiuba.algo3.modelo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TiempoTest {
    @Test
    public void creoInstanciaTiempoYPidoFechaActual(){
        Tiempo t = new Tiempo();
        String fechaEsperada = "domingo, 07 Hs.";
        assert(fechaEsperada.equals(t.tiempoFormateado()));
    }

    @Test
    public void agregoTiempoYPidoFechaActual() throws GameOverException {
        Tiempo t = new Tiempo();
        t.agregarHoras(10);
        String fechaEsperada = "domingo, 17 Hs.";
        assert(fechaEsperada.equals(t.tiempoFormateado()));
    }

    @Test
    public void agrego24HsYPidoFechaActual() throws GameOverException {
        Tiempo t = new Tiempo();
        t.agregarHoras(24);
        String fechaEsperada = "lunes, 07 Hs.";
        assert(fechaEsperada.equals(t.tiempoFormateado()));
    }

    @Test
    public void avanzoMuyCercaDelFinalYPidoFecha() throws GameOverException {
        Tiempo t = new Tiempo();
        t.agregarHoras(177);
        String fechaEsperada = "domingo, 16 Hs.";
        assert(fechaEsperada.equals(t.tiempoFormateado()));
    }

    @Test
    public void mePasoDeTiempoYDevuelveExcepcion(){
        Tiempo t = new Tiempo();
        assertThrows(GameOverException.class, () -> t.agregarHoras(178));
    }
}
