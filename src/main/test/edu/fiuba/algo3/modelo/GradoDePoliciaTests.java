package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.grados.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradoDePoliciaTests {
    @Test
    public void creoUnDetectiveYLeDisparanConArmaDeFuego() {
        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);
        GradoDePolicia detective = new Detective();

        detective.calcularTiempoDeBalazo(cronometro);

        assertEquals(4, tiempo.tiempoTranscurrido());
    }

    @Test
    public void creoUnNovatoYLeDisparanConArmaDeFuego() {
        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);
        GradoDePolicia detective = new Novato();

        detective.calcularTiempoDeBalazo(cronometro);

        assertEquals(4, tiempo.tiempoTranscurrido());
    }

    @Test
    public void creoUnInvestigadorYLeDisparanConArmaDeFuego() {
        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);
        GradoDePolicia detective = new Investigador();
        detective.calcularTiempoDeBalazo(cronometro);

        assertEquals(4, tiempo.tiempoTranscurrido());
    }
    @Test
    public void creoUnDetectiveYDuerme() {
        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);
        GradoDePolicia detective = new Detective();

        detective.calcularTiempoDeViaje(17000, cronometro);


        detective.calcularTiempoDurmiendo(cronometro);

        assertEquals(23, tiempo.tiempoTranscurrido());
    }

    @Test
    public void creoUnSargentoYViaja() {
        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);
        GradoDePolicia detective = new Sargento();

        detective.calcularTiempoDeViaje(10000, cronometro);

        assertEquals(6, tiempo.tiempoTranscurrido());
    }


}
