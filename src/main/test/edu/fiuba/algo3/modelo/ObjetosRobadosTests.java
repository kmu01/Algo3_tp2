package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.objetos.ObjetoComun;
import edu.fiuba.algo3.modelo.objetos.ObjetoMuyValioso;
import edu.fiuba.algo3.modelo.objetos.ObjetoRobado;
import edu.fiuba.algo3.modelo.objetos.ObjetoValioso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObjetosRobadosTests {
    @Test
    public void lePasoUnNumeroAlAzarYVerificaSiObjetoValiosoTieneEsaCantidadDePaises(){
        ObjetoRobado objetoRobado = new ObjetoValioso("Tesoro de caba",new Ciudad("Buenos Aires"));
        int numero = 5;

        assertTrue(objetoRobado.verificarLimitePaises(numero));

    }
    @Test
    public void lePasoUnNumeroAlAzarYVerificaSiObjetoComunTieneEsaCantidadDePaises(){
        ObjetoRobado objetoRobado = new ObjetoComun("Tesoro de caba",new Ciudad("Buenos Aires"));
        int numero = 5;

        assertFalse(objetoRobado.verificarLimitePaises(numero));

    }
    @Test
    public void lePasoUnNumeroAlAzarYVerificaSiObjetoMuyValiosoTieneEsaCantidadDePaises(){
        ObjetoRobado objetoRobado = new ObjetoMuyValioso("Tesoro de caba",new Ciudad("Buenos Aires"));
        int numero = 5;

        assertFalse(objetoRobado.verificarLimitePaises(numero));

    }
}


