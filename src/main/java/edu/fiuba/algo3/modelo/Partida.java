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
    private OrdenDeArresto ordenDeArresto;
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
        this.ciudades = new HashMap<>();
        this.mapa = new Mapa();
        this.ladrones = new ArrayList<>();
        this.objetosRobados = new ArrayList<>();
        this.ladrones = cargarLadrones();
        this.ordenDeArresto = new OrdenSinEmitir();
        cargarCiudades();
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



    public void viajar(String ciudadSeleccionada){

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

    }

    public Pista entrarEdificio(String lugarSeleccionado) {
        this.atrapar();
        //this.ladron.esAtrapado(this.policia, cantidadDePaisesVisitados);

        int numero = this.dado.nextInt(7);
        if (numero == 5){
            this.acuchillar();
        }
        return (this.policia.entrarEdificio(new Lugar(lugarSeleccionado), new Cronometro(this.tiempo),this.dado));
    }


    public void acuchillar(){

            this.policia.recibirCuchillazo(new Cronometro(this.tiempo));
    }

    public void nuevoCaso(int cantidadDeArrestos) {

        GradoDePolicia grado = asignarGradoDePolicia(cantidadDeArrestos);
        ObjetoRobado objetoRobado = seleccionarObjetoRobado(grado);
        Ciudad ciudadInicial = seleccionarCiudadInicial(objetoRobado);
        this.ladron = seleccionarLadron(objetoRobado);
        cargarPistasDescripcionLadron();
        this.policia = new Policia(new Sospechoso(), grado, ciudadInicial);

    }

    public void anotarCualidad(String atributo) {
        Cualidad cualidad = new Cualidad(atributo);
        this.policia.anotarCualidad(cualidad);
    }
    public void cargarDatos(){
        List<Ladron> ladrones = this.policia.cargarDatos(this.comisaria);
        this.emitirOrden(ladrones);
    }

    private void emitirOrden(List<Ladron> ladrones){
        this.ordenDeArresto = this.ordenDeArresto.emitir(ladrones);
    }

    public int cantidadSospechososPosibles(){
        List<Ladron> ladrones = this.policia.cargarDatos(this.comisaria);
        return ladrones.size();
    }

    public boolean atrapar() {
        return (ordenDeArresto.emitida() && this.policia.atrapar(this.ladron,cantidadDePaisesVisitados));
    }

    public int hora() {
        return (this.tiempo.tiempoTranscurrido());
    }

    public void dormir() {
        this.policia.dormir(new Cronometro(this.tiempo));
    }
}