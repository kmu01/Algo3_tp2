package edu.fiuba.algo3.modelo.entrega2;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.grados.Detective;
import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;
import edu.fiuba.algo3.modelo.objetos.ObjetoValioso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasosDeUsoTests {

    List<Cualidad> cualidadesPrimerLadron = new ArrayList<>();
    List<Cualidad> cualidadesSegundoLadron = new ArrayList<>();


    @BeforeEach
    public void setUp(){


        cualidadesPrimerLadron.add(new Cualidad("Masculino"));
        cualidadesPrimerLadron.add(new Cualidad("Correr"));
        cualidadesPrimerLadron.add(new Cualidad("Castaño"));
        cualidadesPrimerLadron.add(new Cualidad("Anteojos"));
        cualidadesPrimerLadron.add(new Cualidad("Comun"));


        cualidadesSegundoLadron.add(new Cualidad("Masculino"));
        cualidadesSegundoLadron.add(new Cualidad("Tenis"));
        cualidadesSegundoLadron.add(new Cualidad("Rubio"));
        cualidadesSegundoLadron.add(new Cualidad("Tatuaje"));
        cualidadesSegundoLadron.add(new Cualidad("Convertible"));

    }

    @Test
    public void elDetectiveEsAcuchilladoYLuegoDuerme(){
        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);
        Ciudad ciudad = new Ciudad();
        Policia policia = new Policia(new Sospechoso(), new Detective(), ciudad);

        policia.recibirCuchillazo(cronometro);
        assertEquals(2, tiempo.tiempoTranscurrido());
        policia.dormir(cronometro);
        assertEquals(10, tiempo.tiempoTranscurrido());

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
        Ladron ladron = new Ladron("Nicokai", cualidadesPrimerLadron);
        Ladron segundoLadron = new Ladron("Jorge Caicedo", cualidadesSegundoLadron);
        ladrones.add(ladron);ladrones.add(segundoLadron);

        when(mockDado.nextInt(3)).thenReturn(1);
        when(mockInicializador.cargarLadrones()).thenReturn(ladrones);
        when(mockInicializador.cargarCiudades()).thenReturn(ciudades);
        when(mockInicializador.cargarPistasLugares(ciudades)).thenReturn(ciudades);
        when(mockInicializador.cargarMapa(ciudades)).thenReturn(mapa);
        when(mockInicializador.cargarObjetosRobados(ciudades)).thenReturn(objetosRobados);

        Partida partida = new Partida(mockInicializador,mockDado);
        partida.nuevoCaso(12);
        partida.viajar("Ciudad de Mexico");

        assertEquals((8),partida.hora());

    }

    @Test
    public void cargarInformacionRecopiladaYBuscarSospechosos(){
        InicializadorDeArchivos inicializadorDeArchivos = new InicializadorDeArchivos();
        Random dado = new Random();
        Partida partida = new Partida(inicializadorDeArchivos,dado);
        partida.nuevoCaso(2);
        partida.anotarCualidad("Femenino");

        assertEquals({},partida.cargarDatos());

    }

    @Test
    public void intentaAtraparSospechosoSinLaOrden(){
        InicializadorDeArchivos inicializadorDeArchivos = new InicializadorDeArchivos();
        Random dado = new Random();
        Partida partida = new Partida(inicializadorDeArchivos,dado);
        partida.nuevoCaso(2);
        partida.anotarCualidad("Femenino");
        partida.cargarDatos();

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
        Ladron ladron = new Ladron("Nicokai", cualidadesPrimerLadron);
        Ladron segundoLadron = new Ladron("Jorge Caicedo", cualidadesSegundoLadron);
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
        partida.anotarCualidad("Masculino");
        assertEquals({},partida.cargarDatos());
        assertFalse(partida.atrapar());
        partida.anotarCualidad("Anteojos");
        assertEquals({},partida.cargarDatos());


        assertTrue(partida.atrapar());

    }
}
