package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.HasSidoBaleadoException;
import edu.fiuba.algo3.modelo.excepciones.TiempoTerminadoException;
import edu.fiuba.algo3.modelo.grados.Sargento;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PoliciaTests {
    @Test
    public void creoUnPoliciaConGradoSargentoLeDanUnDisparoYViajaDeMontrealAMexico() throws TiempoTerminadoException {
        Random dado = mock(Random.class);
        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);
        Mapa mapa = new Mapa();
        Ciudad actual = new Ciudad("Montreal");
        Ciudad destino = new Ciudad("Ciudad de Mexico");
        mapa.agregarCiudad(actual,20,15);
        mapa.agregarCiudad(destino,7, 25);

        Policia policia = new Policia(new Sospechoso(),new Sargento());
        when(dado.nextInt(11)).thenReturn(8);
        assertThrows(HasSidoBaleadoException.class, () -> {
            policia.entrarEdificio(new Lugar("banco"),cronometro,dado, destino);
        });
        policia.viajar(destino,mapa,cronometro, actual);
        assertEquals(5,tiempo.tiempoTranscurrido());
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

        Tiempo tiempo = new Tiempo();
        Cronometro cronometro = new Cronometro(tiempo);

        List<Ladron> ladrones = new ArrayList<>();
        ladrones.add(new Ladron("Nicolas",cualidadesNicolas));
        ladrones.add(new Ladron("Diego",cualidadesDiego));
        Comisaria comisaria = new Comisaria(ladrones);

        Policia policia = new Policia(new Sospechoso(),new Sargento());

        policia.anotarCualidad(new Cualidad("Masculino"));
        policia.anotarCualidad(new Cualidad("Futbol"));

        assertEquals(2,policia.buscarLadrones(comisaria,cronometro).size());

        policia.anotarCualidad(new Cualidad("Tatuaje"));
        policia.anotarCualidad(new Cualidad("Deportivo"));
        policia.anotarCualidad(new Cualidad("Rubio"));


        assertEquals(1,policia.buscarLadrones(comisaria,cronometro).size());
        assertEquals(3,tiempo.tiempoTranscurrido());
    }

}