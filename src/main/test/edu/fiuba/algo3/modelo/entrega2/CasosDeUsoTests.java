package edu.fiuba.algo3.modelo.entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasosDeUsoTests {

    @Test
    public void elDetectiveEsAcuchilladoYLuegoDuerme(){
        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);
        Ciudad ciudad = new Ciudad();
        Policia policia = new Policia(new Sospechoso(), new Detective(), ciudad);

        policia.recibirCuchillazo(cronometro);
        assertEquals(2, tiempo.tiempoRestante());
        policia.dormir(cronometro);
        assertEquals(10, tiempo.tiempoRestante());

    }

    @Test
    public void investigadorTomaCasoYViajaDeMontrealAMexico(){

        List<ObjetoRobado> objetosRobados = new ArrayList<>();
        List<Ladron> ladrones = new ArrayList<>();
        Map<String,Ciudad> ciudades = new HashMap<>();
        Mapa mapa = new Mapa();
        Ciudad montreal = new Ciudad("Montreal");
        Ciudad mexico = new Ciudad("Ciudad de Mexico");
        ciudades.put("Montreal",montreal);
        ciudades.put("Ciudad de Mexico",mexico);
        mapa.agregarCiudad(montreal,100,125);
        mapa.agregarCiudad(mexico,70,20);

        InicializadorDeArchivos mockInicializador = mock(InicializadorDeArchivos.class);
        Random mockDado = mock(Random.class);


        objetosRobados.add(new ObjetoValioso("Incan Gold Mask",montreal));
        Ladron ladron = new Ladron("Nicokai","Masculino","Correr","Castaño","Anteojos","Comun");
        Ladron segundoLadron = new Ladron("Jorge Caicedo","Masculino","Tenis","Rubio","Tatuaje","Convertible");
        ladrones.add(ladron);ladrones.add(segundoLadron);

        when(mockDado.nextInt(3)).thenReturn(1);
        when(mockInicializador.cargarLadrones()).thenReturn(ladrones);
        when(mockInicializador.cargarCiudades()).thenReturn(ciudades);
        when(mockInicializador.cargarPistasLugares(ciudades)).thenReturn(ciudades);
        when(mockInicializador.cargarMapa(ciudades)).thenReturn(mapa);
        when(mockInicializador.cargarObjetosRobados(ciudades)).thenReturn(objetosRobados);

        Partida partida = new Partida(mockInicializador,mockDado);
        partida.nuevoCaso(6);
        partida.viajar("Ciudad de Mexico");

        assertEquals("Ciudad de Mexico",partida.mostrarCiudadActual());
        assertEquals((9),partida.hora());

    }

    @Test
    public void cargarInformacionRecopiladaYBuscarSospechosos(){
        InicializadorDeArchivos inicializadorDeArchivos = new InicializadorDeArchivos();
        Random dado = new Random();
        Partida partida = new Partida(inicializadorDeArchivos,dado);
        partida.nuevoCaso(2);
        partida.anotarGenero("Femenino");

        assertEquals(5,partida.emitirOrderDeArresto().size());

    }

    @Test
    public void intentaAtraparSospechosoSinLaOrden(){
        InicializadorDeArchivos inicializadorDeArchivos = new InicializadorDeArchivos();
        Random dado = new Random();
        Partida partida = new Partida(inicializadorDeArchivos,dado);
        partida.nuevoCaso(2);
        partida.anotarGenero("Femenino");
        partida.emitirOrderDeArresto();

        assertFalse(partida.atrapar());
    }
    @Test
    public void investigacionCompleta(){
        List<Ladron> ladrones = new ArrayList<>();
        Map<String,Ciudad> ciudades = new HashMap<>();
        Mapa mapa = new Mapa();
        Ciudad ciudad = new Ciudad("Ciudad de Mexico");
        ciudades.put("Ciudad de Mexico",ciudad);
        mapa.agregarCiudad(ciudad,100,100);

        Random mockDado = mock(Random.class);
        List<ObjetoRobado> objetosRobados = new ArrayList<>();
        objetosRobados.add(new ObjetoValioso("Incan Gold Mask",new Ciudad("Ciudad de Mexico")));
        Ladron ladron = new Ladron("Nicokai","Masculino","Correr","Castaño","Anteojos","Comun");
        Ladron segundoLadron = new Ladron("Jorge Caicedo","Masculino","Tenis","Rubio","Tatuaje","Convertible");
        ladrones.add(ladron);ladrones.add(segundoLadron);

        when(mockDado.nextInt(3)).thenReturn(1);
        InicializadorDeArchivos mockInicializador = mock(InicializadorDeArchivos.class);
        when(mockInicializador.cargarCiudades()).thenReturn(ciudades);
        when(mockInicializador.cargarPistasLugares(ciudades)).thenReturn(ciudades);
        when(mockInicializador.cargarMapa(ciudades)).thenReturn(mapa);
        when(mockInicializador.cargarLadrones()).thenReturn(ladrones);
        when(mockInicializador.cargarObjetosRobados(ciudades)).thenReturn(objetosRobados);


        Partida partida = new Partida(mockInicializador,mockDado);
        partida.nuevoCaso(6);
        partida.anotarGenero("Masculino");
        List<Ladron> listaDeSospechosos = partida.emitirOrderDeArresto();
        assertEquals(2,listaDeSospechosos.size());
        assertFalse(partida.atrapar());
        partida.anotarSenia("Anteojos");
        listaDeSospechosos = partida.emitirOrderDeArresto();
        assertEquals(1,listaDeSospechosos.size());
        assertEquals("Nicokai",listaDeSospechosos.get(0).nombre());

        assertTrue(partida.atrapar());

    }
}
