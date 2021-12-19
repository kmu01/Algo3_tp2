package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoComun;
import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RutaLadronTests {
    Map<String,Ciudad> ciudades;
    List<String> nombresDeCiudades;
    Random mockDado;
    ObjetoRobado objetoRobado;
    List<String> destinos;
    @BeforeEach
    public void setUp(){
        this.mockDado = mock(Random.class);

        this.ciudades = new HashMap<>();
        this.nombresDeCiudades = new ArrayList<>();
        this.destinos = new ArrayList<>();
        this.destinos.add("Oslo");
        this.destinos.add("Kansas");
        nombresDeCiudades.add("Buenos Aires");
        nombresDeCiudades.add("Rio");
        nombresDeCiudades.add("Oslo");
        nombresDeCiudades.add("Madrid");
        nombresDeCiudades.add("Mendoza");
        nombresDeCiudades.add("Berlin");
        nombresDeCiudades.add("Kansas");
        for (String ciudad: nombresDeCiudades) {
            ciudades.put(ciudad,new Ciudad(ciudad));
        }
        this.objetoRobado = new ObjetoComun("asdasda",ciudades.get("Buenos Aires"));
        when(mockDado.nextInt(nombresDeCiudades.size()-1)).thenReturn(0);
    }
    @Test
    public void crearRutaDeLadron(){
        RutaLadron ruta = new RutaLadron();
        ruta.establecerRutaLadron(objetoRobado,nombresDeCiudades,ciudades,mockDado);
        assertEquals("Buenos Aires",ruta.obtenerCiudadActual().ciudad());
        assertEquals("Rio",ruta.obtenerCiudadSiguiente().ciudad());
    }
    @Test
    public void crearRutaDeLadronConCiudadesDistintas(){
        RutaLadron ruta = new RutaLadron();
        when(mockDado.nextInt(nombresDeCiudades.size()-1)).thenReturn(1);
        ruta.establecerRutaLadron(objetoRobado,nombresDeCiudades,ciudades,mockDado);
        assertEquals("Buenos Aires",ruta.obtenerCiudadActual().ciudad());
        assertEquals("Oslo",ruta.obtenerCiudadSiguiente().ciudad());

    }
    @Test
    public void creaRutaLadronYEligeUnaCiudadCorrecta(){
        RutaLadron ruta = new RutaLadron();
        when(mockDado.nextInt(2)).thenReturn(0);
        ruta.establecerRutaLadron(objetoRobado,nombresDeCiudades,ciudades,mockDado);
        ruta.verificarSiEligioElDestinoCorrecto(ciudades,"Berlin");
        assertEquals(Arrays.asList("Kansas","Berlin"),ruta.verificarDestinos(destinos,mockDado));

    }

}
