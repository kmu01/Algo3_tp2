package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.grados.Sargento;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoliciaTests {
    @Test
    public void creoUnPoliciaConGradoSargentoLeDanUnDisparoYViajaDeMontrealAMexico(){
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
    }
    @Test
    public void creoUnPoliciaConGradoSargentoYLeAnotoAtributosYCargoDatos(){

        List<Ladron> ladrones = new ArrayList<>();
        ladrones.add(new Ladron("Nicolas","Masculino","Futbol","Rubio","Tatuaje","Deportivo"));
        ladrones.add(new Ladron("Diego","Masculino","Futbol","Rubio","Cicatriz","Limusina"));
        Comisaria comisaria = new Comisaria(ladrones);

        Policia policia = new Policia(new Sospechoso(),new Sargento(),new  Ciudad("Ciudad de Mexico"));

        policia.anotarGenero("Masculino");
        policia.anotarHobbie("Futbol");

        assertEquals(2,policia.cargarDatos(comisaria).size());

        policia.anotarSenia("Tatuaje");
        policia.anotarVehiculo("Deportivo");
        policia.anotarCabello("Rubio");

        assertEquals(1,policia.cargarDatos(comisaria).size());
    }
}
