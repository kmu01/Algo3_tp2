package edu.fiuba.algo3.modelo.entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlgoThiefTest {

    @Test
    public void losDatosSeCarganCorrectamente() {
        Partida partida = new Partida();
    }

    @Test
    public void elDetectiveEsAcuchilladoYLuegoDuerme(){
        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);
        Ciudad ciudad = new Ciudad();
        Policia policia = new Policia(new Sospechoso(new ObjetoComun("Tesoro de Montreal")), new Detective(), ciudad);

        policia.recibirCuchillazo(cronometro);
        assertEquals(2, tiempo.tiempoRestante());
        policia.dormir(cronometro);
        assertEquals(10, tiempo.tiempoRestante());

    }
    @Test
    public void investigadorTomaCasoYViajaDeMontrealAMexico(){

    }
    @Test
    public void cargarInformacionRecopiladaYBuscarSospechosos(){
        Policia policia = new Policia(new Sospechoso(new ObjetoComun("tesoro de montreal")),new Detective(),new Ciudad("Montreal"));
        policia.anotarGenero("Femenino");
        policia.cargarDatos();
        /* emitirOrdenDeArresto() va a devolver en que estado está la posibilidad de hacer un arresto,

         */
        assertFalse(policia.emitirOrderDeArresto());

    }
    @Test
    public void intentaAtraparSospechosoSinLaOrden(){
        Policia policia = new Policia(new Sospechoso(new ObjetoComun("tesoro de montreal")),new Detective(),new Ciudad("Montreal"));
        Ladron ladron = new Ladron("Carmen Sandiego","Femenino","Tenis","Marron","Joyas","Depotivo");
        policia.anotarVehiculo("Deportivo");
        policia.anotarGenero("Femenino");
        /* Cuando hacemos cargarDatos() deberia habilitar un atributo
         en policia que permita o no, hacer un arresto a tal ladron. Si cargarDatos() no encuentra un solo sospechoso,
         va a mostrar por el juego la lista de sospechosos.
         */
        policia.cargarDatos();
        /* Depende de si este atributo lo permite o no,
        va a poder atraparlo.
         */
        assertFalse(policia.atrapar(ladron));
    }

    

}