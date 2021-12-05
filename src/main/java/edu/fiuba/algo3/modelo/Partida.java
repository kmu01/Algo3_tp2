package edu.fiuba.algo3.modelo;

import java.util.List;

public class Partida {

    private Policia policia;
    private Ladron ladron;
    private Tiempo tiempo;
    private Mapa mapa;
    private List<Ladron> ladrones;
    private List<Ciudad> ciudades;
    private List<ObjetoRobado> objetosRobados;

    public Partida(){


        cargarLadrones();
        cargarCiudades();
        cargarObjetosRobados();
        cargarMapa();

        GradoDePolicia grado = pedirDatosDelJugador();
        ObjetoRobado objetoRobado = seleccionarObjetoRobado(grado);
        Ciudad ciudadInicial = seleccionarCiudadInicial();
        this.ladron = seleccionarLadron(objetoRobado);

        this.tiempo = new Tiempo();
        this.policia = new Policia(new Sospechoso(objetoRobado), grado, ciudadInicial);

    }

    //Cargar datos
    private void cargarLadrones(){this.ladrones = null;}
    private void cargarCiudades(){this.ciudades = null;}
    private void cargarObjetosRobados(){this.objetosRobados = null;}
    private void cargarMapa(){this.mapa = null;}

    public GradoDePolicia pedirDatosDelJugador() {
        //Pedir datos y determinar el grado

        return new Novato();
    }

    private ObjetoRobado seleccionarObjetoRobado(GradoDePolicia grado){
        //Seleccionar el objeto en base del grado del policia

        return new ObjetoComun("Nombre del objeto robado");

    }

    private Ciudad seleccionarCiudadInicial() {
        //Seleccionar ciudad donde comienza el policia

        return new Ciudad("Nombre de la ciudad inicial");

    }

    private Ladron seleccionarLadron(ObjetoRobado objetoRobado) {
        //Seleccionar ladron seteando el objeto robado

        return new Ladron(objetoRobado, "genero", "hobbie", "cabello", "senia", "vehiculo", new Ciudad("Nombre de la ciuadad donde se encuntra el ladron"));

    }

    public String mostrarCiudadActual(){
        return this.policia.mostrarCiudadActual();
    }


    public void viajar(String ciudadSeleccionada){

        if(!this.tiempo.finalizado()) {
            Ciudad ciudad = new Ciudad(ciudadSeleccionada);
            this.policia.viajar(ciudad, this.mapa, new Cronometro(this.tiempo));
        }

    }

    public void entrarEdificio(String lugarSeleccionado) {

        if (!this.tiempo.finalizado()){
            this.mostrarPista(this.policia.entrarEdificio(new Lugar(lugarSeleccionado), new Cronometro(this.tiempo)));
        }
    }

    private String mostrarPista(Pista pista) {
        return pista.descripcion();
    }

    public void acuchillar(){

        if(!this.tiempo.finalizado()) {
            this.policia.recibirCuchillazo(new Cronometro(this.tiempo));
        }
    }

}