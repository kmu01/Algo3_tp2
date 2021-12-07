package edu.fiuba.algo3.modelo;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

import org.apache.commons.csv.*;

public class Partida {

    private Random dado;
    private InicializadorDeArchivos inicializadorDeArchivos;
    private Policia policia;
    private Comisaria comisaria;
    private Ladron ladron;
    private Tiempo tiempo;
    private Mapa mapa;
    private boolean ordenDeArresto;
    private List<Ladron> ladrones;
    private Map<String,Ciudad> ciudades;
    private List<String> pistasDelLadron;
    private List<ObjetoRobado> objetosRobados;

    public Partida(InicializadorDeArchivos inicializadorDeArchivos,Random dado) {
        this.inicializadorDeArchivos = inicializadorDeArchivos;
        this.tiempo = new Tiempo();
        this.dado = dado;
        this.pistasDelLadron = new ArrayList<>();
        this.ciudades = new HashMap<>();
        this.mapa = new Mapa();
        this.ladrones = new ArrayList<>();
        this.objetosRobados = new ArrayList<>();
        this.ladrones = cargarLadrones();
        cargarCiudades();
        cargarObjetosRobados();
        cargarMapa();
        cargarPistasLugares();

        this.comisaria = new Comisaria(this.ladrones);

    }

    private void cargarMapa() {
        this.mapa = this.inicializadorDeArchivos.cargarMapa();;
    }

    private void cargarPistasDescripcionLadron(){
        this.pistasDelLadron = this.inicializadorDeArchivos.cargarPistasDescripcionLadron(this.pistasDelLadron,this.ladron);
    }

    private void cargarPistasLugares(){
        this.ciudades = this.inicializadorDeArchivos.cargarPistasLugares(this.ciudades);
    }

    private List<Ladron> cargarLadrones(){
        return this.inicializadorDeArchivos.cargarLadrones();
    }

    private void cargarCiudades(){
        this.ciudades = this.inicializadorDeArchivos.cargarCiudades();
    }

    private void cargarObjetosRobados(){
        this.objetosRobados = this.inicializadorDeArchivos.cargarObjetosRobados();
    }

    public GradoDePolicia asignarGradoDePolicia(int cantidadDeArrestos) {

        GradoDePolicia grado;
        switch (cantidadDeArrestos){
            case 0: case 1: case 2: case 3: case 4:
                grado = new Novato();
                break;
            case 5:case 6:case 7: case 8: case 9:
                grado = new Detective();
                break;
            case 10:case 11:case 12: case 13: case 14:case 15: case 16: case 17: case 18: case 19:
                grado = new Investigador();
                break;
            default:
                grado = new Sargento();
        }
        return grado;

    }

    private ObjetoRobado seleccionarObjetoRobado(GradoDePolicia grado){
        //Seleccionar el objeto en base del grado del policia
        return grado.elegirObjeto(this.objetosRobados,this.dado);

    }

    private Ciudad seleccionarCiudadInicial(ObjetoRobado objetoRobado) {
        //Seleccionar ciudad donde comienza el policia

        return objetoRobado.ciudad();

    }

    private Ladron seleccionarLadron(ObjetoRobado objetoRobado) {
        //Seleccionar ladron seteando el objeto robado

        Ladron ladron = ladrones.get(dado.nextInt(ladrones.size()));
        ladron.asignarObjetoRobado(objetoRobado);
        return ladron;

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

        //if(cantidadDePaisesVisitados == this.ladron.objetoRobado.cantidadDePaises && this.ladron.ciudad() == this.policia.ciudad() && this.ladron.escondite()==lugarSeleccionado){this.atrapar();}
        /*Random r = new Random();
        int dado = r.nextInt(7);
        if (dado == 5){
            this.acuchillar();
        }*/
        this.mostrarPista(this.policia.entrarEdificio(new Lugar(lugarSeleccionado), new Cronometro(this.tiempo),this.dado));

    }

    private String mostrarPista(Pista pista) {
        return pista.descripcion();
    }

    public void acuchillar(){

        if(!this.tiempo.finalizado()) {
            this.policia.recibirCuchillazo(new Cronometro(this.tiempo));
        }
    }

    public void nuevoCaso(int cantidadDeArrestos) {

        GradoDePolicia grado = asignarGradoDePolicia(cantidadDeArrestos);
        ObjetoRobado objetoRobado = seleccionarObjetoRobado(grado);
        Ciudad ciudadInicial = seleccionarCiudadInicial(objetoRobado);
        this.ladron = seleccionarLadron(objetoRobado);
        cargarPistasDescripcionLadron();
        this.policia = new Policia(new Sospechoso(), grado, ciudadInicial);

    }

    public void anotarGenero(String genero) {
        this.policia.anotarGenero(genero);
    }

    public List<Ladron> emitirOrderDeArresto() {
        List<Ladron> ladrones = this.policia.cargarDatos(this.comisaria);
        this.ordenDeArresto = (ladrones.size() == 1);
        return ladrones;
    }

    public boolean atrapar() {
        return (ordenDeArresto && this.policia.atrapar(this.ladron));
    }

    public void anotarSenia(String senia) {
        this.policia.anotarSenia(senia);
    }
}