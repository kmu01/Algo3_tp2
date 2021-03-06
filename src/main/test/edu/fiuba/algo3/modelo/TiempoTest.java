package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.TiempoTerminadoException;
import edu.fiuba.algo3.modelo.ubicacion.Tiempo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TiempoTest {
    @Test
    public void creoInstanciaTiempoYPidoFechaActual(){
        Tiempo t = new Tiempo();
        String fechaEsperada = "Monday, 07 Hs.";
        assertEquals(fechaEsperada,t.tiempoFormateado());
    }

    @Test
    public void agregoTiempoYPidoFechaActual() throws TiempoTerminadoException {
        Tiempo t = new Tiempo();
        t.agregarHoras(10);
        String fechaEsperada = "Monday, 17 Hs.";
        assertEquals(fechaEsperada,t.tiempoFormateado());
    }

    @Test
    public void agrego24HsYPidoFechaActual() throws TiempoTerminadoException {
        Tiempo t = new Tiempo();
        t.agregarHoras(24);
        String fechaEsperada = "Tuesday, 07 Hs.";
        assertEquals(fechaEsperada,t.tiempoFormateado());
    }

    @Test
    public void avanzoMuyCercaDelFinalYPidoFecha() throws TiempoTerminadoException {
        Tiempo t = new Tiempo();
        t.agregarHoras(153);
        String fechaEsperada = "Sunday, 16 Hs.";
        assertEquals(fechaEsperada,t.tiempoFormateado());
    }

    @Test
    public void mePasoDeTiempoYDevuelveExcepcion(){
        Tiempo t = new Tiempo();
        assertThrows(TiempoTerminadoException.class, () -> t.agregarHoras(155));
    }
}
