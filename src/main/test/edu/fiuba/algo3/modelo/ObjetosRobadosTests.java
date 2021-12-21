package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.ObjetoComun;
import edu.fiuba.algo3.modelo.objetos.ObjetoMuyValioso;
import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;
import edu.fiuba.algo3.modelo.objetos.ObjetoValioso;
import edu.fiuba.algo3.modelo.ubicacion.Ciudad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjetosRobadosTests {
    Ciudad ciudad;
    @BeforeEach
    public void setUp(){
        ciudad = new Ciudad("Buenos Aires");
    }
    @Test
    public void lePasoUnNumeroAlAzarYVerificaSiObjetoValiosoTieneEsaCantidadDePaises(){
        ObjetoRobado objetoRobado = new ObjetoValioso("Tesoro de caba",ciudad);
        int numero = 5;


        assertEquals(objetoRobado.cantidadPaises(),5);
        assertEquals(objetoRobado.rareza(),"valioso");
        assertTrue(objetoRobado.verificarLimitePaises(numero));

    }
    @Test
    public void lePasoUnNumeroAlAzarYVerificaSiObjetoComunTieneEsaCantidadDePaises(){
        ObjetoRobado objetoRobado = new ObjetoComun("Tesoro de caba",ciudad);
        int numero = 5;

        assertEquals(objetoRobado.cantidadPaises(),4);
        assertEquals(objetoRobado.rareza(),"comun");
        assertFalse(objetoRobado.verificarLimitePaises(numero));

    }
    @Test
    public void lePasoUnNumeroAlAzarYVerificaSiObjetoMuyValiosoTieneEsaCantidadDePaises(){
        ObjetoRobado objetoRobado = new ObjetoMuyValioso("Tesoro de caba",ciudad);
        int numero = 5;

        assertEquals(objetoRobado.cantidadPaises(),7);
        assertEquals(objetoRobado.rareza(),"muy valioso");
        assertFalse(objetoRobado.verificarLimitePaises(numero));

    }
}


