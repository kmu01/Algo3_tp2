package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrdenDeArrestoTests {
    Ladron ladron1;
    Ladron ladron2;
    List<Cualidad> cualidesLadron1 = new ArrayList<>();
    List<Cualidad> cualidadesLadron2 = new ArrayList<>();

    @BeforeEach
    public void setUp(){
        cualidesLadron1.add(new Cualidad("rubio"));
        cualidesLadron1.add(new Cualidad("Masculino"));
        cualidesLadron1.add(new Cualidad("morocho"));
        cualidesLadron1.add(new Cualidad("Masculino"));

        ladron1 = new Ladron("Nicokai",cualidesLadron1);
        ladron2 = new Ladron("Gabriel",cualidadesLadron2);
    }

    @Test
    public void consultoSiSeEmitioOrdenDeArrestoCuandoNoSeEmite(){
        List<Ladron> ladrones = new ArrayList<>();
        ladrones.add(ladron1);ladrones.add(ladron2);
        OrdenDeArresto ordenDeArresto = new OrdenSinEmitir();

        ordenDeArresto = ordenDeArresto.emitir(ladrones);
        assertFalse(ordenDeArresto.emitida());

    }
    @Test
    public void consultoSiSeEmiteOrdenDeArrestoCuandoSeEmite(){
        List<Ladron> ladrones = new ArrayList<>();
        ladrones.add(ladron1);
        OrdenDeArresto ordenDeArresto = new OrdenSinEmitir();

        ordenDeArresto = ordenDeArresto.emitir(ladrones);
        assertTrue(ordenDeArresto.emitida());
    }
    @Test
    public void consultoSiSeEmiteOrdenDeArrestoCuandoYaSeEmitio(){
        List<Ladron> ladrones = new ArrayList<>();
        ladrones.add(ladron1);
        OrdenDeArresto ordenDeArresto = new OrdenEmitida(ladron1);

        assertTrue(ordenDeArresto.emitida());

        ordenDeArresto = ordenDeArresto.emitir(ladrones);

        assertTrue(ordenDeArresto.emitida());
    }
}
