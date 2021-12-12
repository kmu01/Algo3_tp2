package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.grados.Sargento;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoliciaTests {
    @Test
    public void creoUnPoliciaConGradoSargentoLeDanUnDisparoYViajaDeMontrealAMexico() throws GameOverException {
        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);
        Mapa mapa = new Mapa();
        Ciudad actual = new Ciudad("Montreal");
        Ciudad destino = new Ciudad("Ciudad de Mexico");
        mapa.agregarCiudad(actual,20,15);
        mapa.agregarCiudad(destino,7, 25);

        Policia policia = new Policia(new Sospechoso(),new Sargento(),actual);
        policia.recibirHeridaDeBala(cronometro);
        policia.viajar(destino,mapa,cronometro);

        assertEquals(5,tiempo.tiempoTranscurrido());
        assertEquals("lunes, 12 Hs.", tiempo.tiempoFormateado());
    }
    @Test
    public void creoUnPoliciaConGradoSargentoYLeAnotoAtributosYCargoDatos(){
        List<Cualidad> cualidadesNicolas = new ArrayList<>();
        cualidadesNicolas.add(new Cualidad("Masculino"));
        cualidadesNicolas.add(new Cualidad("Futbol"));
        cualidadesNicolas.add(new Cualidad("Rubio"));
        cualidadesNicolas.add(new Cualidad("Tatuaje"));
        cualidadesNicolas.add(new Cualidad("Deportivo"));

        List<Cualidad> cualidadesDiego = new ArrayList<>();
        cualidadesDiego.add(new Cualidad("Masculino"));
        cualidadesDiego.add(new Cualidad("Futbol"));
        cualidadesDiego.add(new Cualidad("Rubio"));
        cualidadesDiego.add(new Cualidad("Cicatriz"));
        cualidadesDiego.add(new Cualidad("Limusina"));


        List<Ladron> ladrones = new ArrayList<>();
        ladrones.add(new Ladron("Nicolas",cualidadesNicolas));
        ladrones.add(new Ladron("Diego",cualidadesDiego));
        Comisaria comisaria = new Comisaria(ladrones);

        Policia policia = new Policia(new Sospechoso(),new Sargento(),new  Ciudad("Ciudad de Mexico"));

        policia.anotarCualidad(new Cualidad("Masculino"));
        policia.anotarCualidad(new Cualidad("Futbol"));

        assertEquals(2,policia.buscarLadrones(comisaria).size());

        policia.anotarCualidad(new Cualidad("Tatuaje"));
        policia.anotarCualidad(new Cualidad("Deportivo"));
        policia.anotarCualidad(new Cualidad("Rubio"));

        assertEquals(1,policia.buscarLadrones(comisaria).size());
    }
}
