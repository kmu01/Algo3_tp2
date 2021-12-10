package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.grados.GradoDePolicia;

import java.util.List;
import java.util.Random;

public class Policia {

    private GradoDePolicia grado;
    private Sospechoso sospechoso;
    private Ciudad ciudadActual;
    private int cantidadDeVecesAcuchillado;

    public Policia(Sospechoso sospechoso, GradoDePolicia grado, Ciudad ciudadInicial){

        this.grado = grado;
        this.sospechoso = sospechoso;
        this.ciudadActual = ciudadInicial;
        this.cantidadDeVecesAcuchillado = 0;

    }

    public void anotarGenero(String genero){

        this.sospechoso.anotarGenero(genero);

    }

    public void anotarCabello(String colorDePelo){
        this.sospechoso.anotarCabello(colorDePelo);
    }
    public void anotarHobbie(String hobbie){
        this.sospechoso.anotarHobbie(hobbie);
    }

    public void anotarVehiculo(String vehiculo){
        this.sospechoso.anotarVehiculo(vehiculo);
    }
    public void anotarSenia(String senia){
        this.sospechoso.anotarSenia(senia);
    }

    public Pista entrarEdificio(Lugar lugarSeleccionado, Cronometro cronometro, Random dado){

        return this.ciudadActual.visitar(lugarSeleccionado, this.grado, cronometro,dado);

    }

    public void viajar(Ciudad ciudadSeleccionada, Mapa mapa, Cronometro cronometro) throws GameOverException {


        float distancia = mapa.calcularDistancia(ciudadSeleccionada,this.ciudadActual);
        this.grado.calcularTiempoDeViaje(distancia, cronometro);
        this.ciudadActual = ciudadSeleccionada;

    }

    public String mostrarCiudadActual(){
        return (this.ciudadActual.nombre());
    }

    public void recibirCuchillazo(Cronometro cronometro){

        cronometro.calcularTiempoDeCuchillazo(++this.cantidadDeVecesAcuchillado);

    }
    public void recibirHeridaDeBala(Cronometro cronometro){
        this.grado.calcularTiempoDeBalazo(cronometro);
    }

    public void dormir(Cronometro cronometro){

        this.grado.calcularTiempoDurmiendo(cronometro);

    }
    public List<Ladron> cargarDatos(Comisaria comisaria){
        return comisaria.cargarDatos(this.sospechoso);
    }

    public boolean atrapar(Ladron ladron) {
        return ((this.ciudadActual.nombre()).equals(ladron.ciudad().nombre()));
    }
}
