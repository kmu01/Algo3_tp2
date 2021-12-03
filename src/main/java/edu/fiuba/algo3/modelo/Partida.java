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

        this.tiempoDeLaPartida = new Tiempo();
    }
    public String mostrarCiudadActual(){
        return (this.policia.mostrarCiudadActual());
    }
    public void sumarTiempo(float tiempoASumar) {
        try {
            this.tiempoDeLaPartida.agregarTiempo(tiempoASumar);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void viajar(String ciudadSeleccionada){
        Ciudad ciudad = new Ciudad(ciudadSeleccionada);
        float tiempo = this.policia.viajar(ciudad);
        sumarTiempo(tiempo);
        int numero = (int) Math.floor(Math.random()*10+1);
        if (numero == 1){
            acuchillar();
        }
    }
    public void entrarEdificio(Lugar lugarSeleccionado){

        int tiempo = this.policia.entrarEdificio(lugarSeleccionado);
        sumarTiempo(tiempo);

    }
    public void acuchillar(){
        int tiempo = this.ladron.acuchillar(this.policia);
        sumarTiempo(tiempo);

    }

}
