package edu.fiuba.algo3.modelo;

import java.util.*;

import edu.fiuba.algo3.modelo.excepciones.GameOverException;
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
    private List<Ladron> ladrones;
    private Map<String,Ciudad> ciudades;
    private List<String> pistasDelLadron;
    private List<ObjetoRobado> objetosRobados;
    private int cantidadDePaisesVisitados = 0;
    private Ciudad ciudadSiguiente;
    private Ciudad ciudadActual;



    public Partida(InicializadorDeArchivos inicializadorDeArchivos,Random dado) {
        this.inicializadorDeArchivos = inicializadorDeArchivos;
        this.tiempo = new Tiempo();
        this.dado = dado;

        this.pistasDelLadron = new ArrayList<>();
        this.ciudades = null;
        this.mapa = null;
        this.ladrones = null;
        this.objetosRobados = null;
        this.ladrones = cargarLadrones();
        cargarCiudades();
        System.out.println("Cargan las ciudades bien,"+ this.ciudades.size());
        cargarObjetosRobados();
        cargarMapa();
        cargarPistasLugares();

        this.comisaria = new Comisaria(this.ladrones);

    }

    private void cargarMapa() {

        this.mapa = this.inicializadorDeArchivos.cargarMapa(this.ciudades);

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
        switch(cantidadDeArrestos){
            case 0: case 1: case 2: case 3: case 4:
                grado = new Novato();
                break;
            case 5: case 6: case 7: case 8: case 9:
                grado = new Detective();
                break;
            case 10: case 11: case 12: case 13: case 14: case 15: case 16: case 17: case 18: case 19:
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

    private Policia inicializarPolicia(ObjetoRobado objetoRobado,GradoDePolicia grado) {

        //Seleccionar ciudad donde comienza el policia
        return objetoRobado.crearPoliciaConCiudadInicial(grado);

    }

    private Ladron seleccionarLadron(ObjetoRobado objetoRobado) {

        //Seleccionar ladron seteando el objeto robado

        Ladron ladron = ladrones.get(dado.nextInt(ladrones.size()));
        ladron.asignarObjetoRobado(objetoRobado);
        return ladron;

    }

    public void viajar(String ciudadSeleccionada){
        /*Cola colaRutaLadron;
        Pila pilaDestinos;
        cola = definoRutaLadron(colaRutaLadron);
        ciudadSiguiente = colaRutaLadron.desacolar();
        if (ciudadSiguiente != ciudadElegida){
            pilaDestinos.apilar(ciudadSiguiente);
            ciudadSiguiente = ciudadActual;
            ciudadActual = ciudadElegida;
        }else{// Si acerto el destino
            if(pilaDestinos.estaVacia()){
                ciudadSiguiente = cola.desacolar();
                ciudadActual = ciudadElegida;
            }
            ciudadActual = ciudadElegida;
            ciudadSiguiente = pilaDestinos.desapilar();

        }*/


        try {
            Ciudad ciudad = this.ciudades.get(ciudadSeleccionada);
            /*if (ciudadSiguiente.esCiudad(ciudadSeleccionada)){
                ciudadSiguiente = desapilo();
                ciudadActual = ciudad;
            }else{
                se apila ciudadSiguiente;
                ciudadSiguiente = ciudadActual; //Debo recordar cual es el camino correcto
                ciudadActual = ciudad;
            }*/
            this.policia.viajar(ciudad, this.mapa, new Cronometro(this.tiempo));
            this.cantidadDePaisesVisitados++;

        }catch(GameOverException e){

        }
        try {
            this.policia.dormir(new Cronometro(this.tiempo));
        } catch (GameOverException e) {
            e.printStackTrace();
        }

    }

    public Pista entrarEdificio(String lugarSeleccionado) throws GameOverException {

        //Chequear que las colas esten vacías y si es así llamar a this.policiar.atrapar();
        /*ciudadCorrecta = null;
        * proximaCiudadCorrecta = japon;
        * ciudadActual = mexico;
        * ultimaCiudadCorrecta = mexico;
        *
        * mexico-> japon;
        * mexico viaja a italia
        * si acerto:
        * ultimaCiudadCorrecta = ciudadActual;
        * ciudadActual = proximaCiudadCorrecta
        * proximaCiudadCorrecta = random();
        *

        *si se equivoco:
        * rellenar pistas falsas
        * ciudadActual = ciudadElegida;
        * agregarUltimaCiudadCorrectaAPosiblesDestinos
        *
        * italia->mexico
        * italia viaja a china
        * china-> italia
        * posibles destinos china son: italia,mexico,buenos aires y rio
        *
        * this.policia.atrapar()
        *
        * }
        * */
        if(this.atrapar()){
            throw new GameOverException();
        }

        try {
            this.policia.dormir(new Cronometro(this.tiempo));
        } catch (GameOverException e) {
            e.printStackTrace();
        }
        Pista pistaObtenida = null;
        int numero = this.dado.nextInt(7);
        if (numero == 5){
            this.acuchillar();
        }
        try {
            pistaObtenida = (this.policia.entrarEdificio(new Lugar(lugarSeleccionado), new Cronometro(this.tiempo),this.dado));
        } catch (GameOverException e) {
            e.printStackTrace();
        }
        return pistaObtenida;
    }

    private void acuchillar() {

        try {
            this.policia.recibirCuchillazo(new Cronometro(this.tiempo));
        } catch (GameOverException e) {
            e.printStackTrace();
        }
    }

    public void nuevoCaso(int cantidadDeArrestos) {

        GradoDePolicia grado = asignarGradoDePolicia(cantidadDeArrestos);
        ObjetoRobado objetoRobado = seleccionarObjetoRobado(grado);
        this.ladron = seleccionarLadron(objetoRobado);
        cargarPistasDescripcionLadron();
        this.policia = this.inicializarPolicia(objetoRobado,grado);

    }

    public void anotarCualidad(String atributo) {
        Cualidad cualidad = new Cualidad(atributo);
        this.policia.anotarCualidad(cualidad);
    }
    public List<Ladron> buscarLadrones(){

        List<Ladron> ladrones = this.policia.buscarLadrones(this.comisaria);
        return ladrones;
    }

    private boolean atrapar() {
        return (this.policia.atrapar());
    }

    public String hora() {
        return (this.tiempo.tiempoFormateado());
    }

}