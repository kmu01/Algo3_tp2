package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgoThiefTest {
    @Test
    public void elDetectiveComienzaEnMontrealYEntraAlBancoYPideUnaPista() {
        Policia policia = new Novato();
        AlgoThief juego = new AlgoThief();
        juego.ladronABuscar('Tesoro nacional de Montreal');//Acá se supone busca a un ladron del archivo de texto
        // y se le pasa por parámetro el objetoRobado
        juego.inscribirPolicia(policia, 'Montreal')//Montreal es la ciudad donde arranca
        juego.anotarDescripcion('Femenino');
        String pista = juego.entrarEdificio(new Banco());
        assertEquals('Aca va la pista que debe devolver', pista.mostrarPista());
        int horasFaltantes = 100;
        assertEquals(horasFaltantes, policia.mostrarTiempo());
    }

    @Test
    public void elDetectiveComienzaEnMontrealYEntraAUnBancoYUnaBiblioteca() {
        Policia policia = new Novato();
        AlgoThief juego = new AlgoThief();
        juego.ladronABuscar('Tesoro nacional de Montreal');
        juego.inscribirPolicia(policia, 'Montreal');
        juego.anotarDescripcion('Femenino');
        juego.anotarDescripcion('Pelo morocho');
        Pista textoDeLaPista = juego.entrarEdificio(new Banco());
        assertEquals('Aca va la pista que debe devolver',textoDeLaPista.mostrarPista());
        textoDeLaPista = juego.entrarEdificio(new Biblioteca());
        assertEquals('Aca va la poista que debe devolver',textoDeLaPista.mostrarPista());
        int hora = "Lunes 7:00"; // numero magico..hay que fijarse cual iria y reemplazar
        assertEquals(hora,policia.mostrarTiempo());
    }

    @Test
    public void elDetectiveViajaDeMontrealACiudadDeMexico(){
        Policia policia = new Novato("Montreal");
        policia.viajar('Ciudad de Mexico');
        assertEquals('Ciudad de Mexico',policia.mostrarCiudadActual());
        int hora = "Lunes 12:00";
        assertEquals(hora,policia.mostrarTiempo());
    }

    @Test
    public void elDetectiveEsAcuchilladoYLuegoDuerme(){

        Policia policia = new Novato();
        policia.herirConCuchillo();
        String hora = "Lunes 8:00";
        assertEquals(hora,policia.mostrarTiempo());
        policia.dormir();
        String horaDespuesDeDormir = "Lunes 16:00";
        assertEquals(HoraDespuesDeDormir,policia.mostrarTiempo());

    }
}