package edu.fiuba.algo3.modelo;

import java.util.List;

public class Partida {
    private Policia policia;
    private Ladron ladron;
    private Tiempo tiempoDeLaPartida;
    private List<String> ladrones;
    private List<Ciudad> ciudades;
    private List<String> objetosRobados;

    public Partida(){
       this.policia = new Policia("asda",0,new Ciudad("Montreal"),new Mapa());
        this.ladron = new Ladron(0,"asda","femenino","ajedrez","rubio","joya","auto");
        this.tiempoDeLaPartida = new Tiempo();
    }

    public void sumarTiempo(int tiempoASumar) {
        try {
            this.tiempoDeLaPartida.agregarTiempo(tiempoASumar);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void viajar(String ciudadSeleccionada){
        Ciudad ciudad = new Ciudad("hola");
        int tiempo = this.policia.viajar(ciudad);
        sumarTiempo(tiempo);
        int numero = (int) Math.floor(Math.random()*10+1);
        if (numero == 1){
            acuchillar();
        }
    }
    public void entrarEdificio(String lugarSeleccionado){

        int tiempo = this.policia.entrarEdificio(lugarSeleccionado);
        sumarTiempo(tiempo);

    }
    public void acuchillar(){
        int tiempo = this.ladron.acuchillar(this.policia);
        sumarTiempo(tiempo);

    }

}
