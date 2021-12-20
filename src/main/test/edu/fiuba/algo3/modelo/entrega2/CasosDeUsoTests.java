package edu.fiuba.algo3.modelo.entrega2;

import edu.fiuba.algo3.modelo.*;

import edu.fiuba.algo3.modelo.excepciones.HasSidoAcuchilladoException;
import edu.fiuba.algo3.modelo.excepciones.JuegoGanadoException;
import edu.fiuba.algo3.modelo.excepciones.NoTieneOrdenDeArrestoException;
import edu.fiuba.algo3.modelo.grados.Detective;
import edu.fiuba.algo3.modelo.grados.Investigador;
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
    List<Cualidad> cualidadesTercerLadron = new ArrayList<>();
    Map<String,Ciudad> ciudades = new HashMap<>();
    Tiempo tiempo;
    Cronometro cronometro;
    Mapa mapa;
    Ciudad montreal;
    Ciudad ciudadDeMexico;
    Random dado;



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

        cualidadesTercerLadron.add(new Cualidad("Femenino"));
        cualidadesTercerLadron.add(new Cualidad("Alpinismo"));
        cualidadesTercerLadron.add(new Cualidad("Castaño"));
        cualidadesTercerLadron.add(new Cualidad("Tatuaje"));
        cualidadesTercerLadron.add(new Cualidad("Moto"));

        tiempo = new Tiempo();
        cronometro = new Cronometro(tiempo);

        mapa = new Mapa();
        montreal = new Ciudad("Montreal");
        ciudadDeMexico = new Ciudad("Ciudad de Mexico");
        ciudades.put("Montreal",montreal);
        ciudades.put("Ciudad de Mexico",ciudadDeMexico);
        mapa.agregarCiudad(montreal,100,125);
        mapa.agregarCiudad(ciudadDeMexico,70,20);
        dado = mock(Random.class);
        when(dado.nextInt(3)).thenReturn(1);

    }

    @Test
    public void elDetectiveEsAcuchilladoYLuegoDuermePeroNoPuede(){
        Ciudad ciudad = new Ciudad("jamaica");
        Policia policia = new Policia(new Sospechoso(), new Detective());

        when(dado.nextInt(15)).thenReturn(5);
        assertThrows(HasSidoAcuchilladoException.class, () -> policia.entrarEdificio(new Lugar("Banco"), cronometro, dado, ciudadDeMexico));

        assertEquals(2, tiempo.tiempoTranscurrido());
        assertEquals("Monday, 09 Hs.", tiempo.tiempoFormateado());

        policia.dormir(cronometro);

        assertEquals(2, tiempo.tiempoTranscurrido());

    }

    @Test
    public void investigadorTomaCasoYViajaDeMontrealAMexico(){

        Policia policia = new Policia(new Sospechoso(), new Investigador());
        policia.viajar(ciudadDeMexico, mapa, cronometro, montreal);

        assertEquals("Monday, 15 Hs.", tiempo.tiempoFormateado());
    }

    @Test
    public void cargarInformacionRecopiladaYBuscarSospechosos(){

        List<Ladron> ladrones = new ArrayList<>();
        Ladron nicokai = new Ladron("Nicokai", cualidadesPrimerLadron);
        Ladron jorgeCaicedo = new Ladron("Jorge Caicedo", cualidadesSegundoLadron);
        Ladron marcela = new Ladron("Marcela", cualidadesTercerLadron);

        ladrones.add(nicokai);ladrones.add(jorgeCaicedo);ladrones.add(marcela);

        Comisaria comisaria = new Comisaria(ladrones);

        Policia policia = new Policia(new Sospechoso(), new Investigador());
        policia.anotarCualidad(new Cualidad("Femenino"));

        assertEquals(Arrays.asList(marcela), policia.buscarLadrones(comisaria));


    }

    @Test
    public void intentaAtraparSospechosoSinLaOrden(){

        List<Ladron> ladrones = new ArrayList<>();
        Ladron nicokai = new Ladron("Nicokai", cualidadesPrimerLadron);
        Ladron jorgeCaicedo = new Ladron("Jorge Caicedo", cualidadesSegundoLadron);
        Ladron marcela = new Ladron("Marcela", cualidadesTercerLadron);

        ladrones.add(nicokai);ladrones.add(jorgeCaicedo);ladrones.add(marcela);

        Comisaria comisaria = new Comisaria(ladrones);

        Policia policia = new Policia(new Sospechoso(), new Investigador());
        policia.anotarCualidad(new Cualidad("Masculino"));

        List<Ladron> ladronesObtenidos = policia.buscarLadrones(comisaria);


        assertEquals(Arrays.asList(nicokai,jorgeCaicedo),ladronesObtenidos);

        assertThrows(NoTieneOrdenDeArrestoException.class,()->{policia.comprobarVictoria(new RutaLadron());});

    }

    @Test
    public void investigacionCompleta(){

        Ciudad lima = new Ciudad("Lima");
        Pista pista = new Pista(new Dificultad("Medio"), "Pista Media", "banco");
        pista.asignarPistaDeLadron(".Tiene el pelo rubio");
        lima.agregarPista(pista);
        mapa.agregarCiudad(lima,70,20);
        ciudades.put("Lima", lima);

        List<Ladron> ladrones = new ArrayList<>();
        Ladron nicokai = new Ladron("Nicokai", cualidadesPrimerLadron);
        Ladron jorgeCaicedo = new Ladron("Jorge Caicedo", cualidadesSegundoLadron);
        Ladron marcela = new Ladron("Marcela", cualidadesTercerLadron);
        marcela.asignarObjetoRobado(new ObjetoValioso("Inka Golden Mask", lima));
        ladrones.add(nicokai);ladrones.add(jorgeCaicedo);ladrones.add(marcela);

        Pista pistaObtenidaDelBanco = null;
        Comisaria comisaria = new Comisaria(ladrones);
        Policia policia = new Policia(new Sospechoso(), new Detective());
        pistaObtenidaDelBanco = policia.entrarEdificio(new Lugar("banco"), cronometro, dado, lima);
        policia.viajar(montreal, mapa, cronometro,lima);
        policia.anotarCualidad(new Cualidad("Femenino"));
        policia.buscarLadrones(comisaria);


        assertThrows(JuegoGanadoException.class,()->{policia.comprobarVictoria(new RutaLadron());});
        assertEquals("Pista Media .Tiene el pelo rubio", pistaObtenidaDelBanco.descripcion());
    }
}
