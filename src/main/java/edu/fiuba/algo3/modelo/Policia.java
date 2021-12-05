package edu.fiuba.algo3.modelo;

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

    public Pista entrarEdificio(Lugar lugarSeleccionado, Cronometro cronometro){

        return this.ciudadActual.visitar(lugarSeleccionado, this.grado, cronometro);

    }

    public void viajar(Ciudad ciudadSeleccionada, Mapa mapa, Cronometro cronometro) {


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

    public void dormir(Cronometro cronometro){

        this.grado.calcularTiempoDurmiendo(cronometro);

    }
}
