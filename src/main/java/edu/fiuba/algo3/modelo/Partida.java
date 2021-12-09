package edu.fiuba.algo3.modelo;

import java.util.*;
import edu.fiuba.algo3.modelo.grados.*;
import edu.fiuba.algo3.modelo.objetos.*;

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
    private int cantidadDePaisesVisitados = 0;

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
        this.mapa = this.inicializadorDeArchivos.cargarMapa(this.ciudades);;
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
        this.objetosRobados = this.inicializadorDeArchivos.cargarObjetosRobados(this.ciudades);
    }

    public GradoDePolicia asignarGradoDePolicia(int cantidadDeArrestos) {

        GradoDePolicia grado;
        if (cantidadDeArrestos >= 0 && cantidadDeArrestos < 5){
            grado = new Novato();
        } else if (cantidadDeArrestos >= 5 && cantidadDeArrestos < 10){
            grado = new Detective();
        } else if(cantidadDeArrestos >= 10 && cantidadDeArrestos < 20) {
            grado = new Investigador();
        } else {
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
            Ciudad ciudad = this.ciudades.get(ciudadSeleccionada);
            this.policia.viajar(ciudad, this.mapa, new Cronometro(this.tiempo));
            this.cantidadDePaisesVisitados++;
        }

    }

    public Pista entrarEdificio(String lugarSeleccionado) {

        if(cantidadDePaisesVisitados == this.ladron.objetoRobado.cantidadPaises() &&
                this.ladron.ciudad().nombre().equals(this.policia.mostrarCiudadActual()))
        {this.atrapar();}

        int numero = this.dado.nextInt(7);
        if (numero == 5){
            this.acuchillar();
        }
        return (this.policia.entrarEdificio(new Lugar(lugarSeleccionado), new Cronometro(this.tiempo),this.dado));

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

    public int cantidadSospechososPosibles() {
        List<Ladron> ladrones = this.policia.cargarDatos(this.comisaria);
        return ladrones.size();
    }

    public boolean atrapar() {
        return (ordenDeArresto && this.policia.atrapar(this.ladron));
    }

    public void anotarSenia(String senia) {
        this.policia.anotarSenia(senia);
    }

    public int hora() {
        return (this.tiempo.tiempoTranscurrido());
    }

    public void dormir() {
        this.policia.dormir(new Cronometro(this.tiempo));
    }
}