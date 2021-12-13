package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.GameOverException;
import edu.fiuba.algo3.modelo.grados.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradoDePoliciaTests {
    @Test
    public void creoUnDetectiveYLeDisparanConArmaDeFuego() {
        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);
        GradoDePolicia detective = new Detective();
        try {
            detective.calcularTiempoDeBalazo(cronometro);
        } catch (GameOverException e) {
            e.printStackTrace();
        }
        assertEquals(4, tiempo.tiempoTranscurrido());
    }

    @Test
    public void creoUnNovatoYLeDisparanConArmaDeFuego() {
        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);
        GradoDePolicia detective = new Novato();
        try {
            detective.calcularTiempoDeBalazo(cronometro);
        } catch (GameOverException e) {
            e.printStackTrace();
        }
        assertEquals(4, tiempo.tiempoTranscurrido());
    }

    @Test
    public void creoUnInvestigadorYLeDisparanConArmaDeFuego() {
        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);
        GradoDePolicia detective = new Investigador();
        try {
            detective.calcularTiempoDeBalazo(cronometro);
        } catch (GameOverException e) {
            e.printStackTrace();
        }
        assertEquals(4, tiempo.tiempoTranscurrido());
    }
    @Test
    public void creoUnDetectiveYDuerme() {
        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);
        GradoDePolicia detective = new Detective();
        try {
            detective.calcularTiempoDeViaje(17000, cronometro);
        } catch (GameOverException e) {
            e.printStackTrace();
        }
        try {
            detective.calcularTiempoDurmiendo(cronometro);
        } catch (GameOverException e) {
            e.printStackTrace();
        }
        assertEquals(23, tiempo.tiempoTranscurrido());
    }

    @Test
    public void creoUnSargentoYViaja() {
        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);
        GradoDePolicia detective = new Sargento();
        try {
            detective.calcularTiempoDeViaje(10000, cronometro);
        } catch (GameOverException e) {
            e.printStackTrace();
        }
        assertEquals(6, tiempo.tiempoTranscurrido());
    }


}
