package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.*;

import edu.fiuba.algo3.modelo.excepciones.TiempoTerminadoException;
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
    private Queue<Ciudad> rutaLadron;
    private Stack<String> destinosEquivocados;
    private List<Ladron> ladrones;
    private Map<String,Ciudad> ciudades;
    private List<String> pistasDelLadron;
    private List<ObjetoRobado> objetosRobados;
    private int cantidadDePaisesVisitados = 0;
    private Ciudad ciudadSiguiente;
    private Ciudad ciudadActual;



    public Partida(InicializadorDeArchivos inicializadorDeArchivos,Random dado) throws IOException {
        this.inicializadorDeArchivos = inicializadorDeArchivos;
        this.tiempo = new Tiempo();
        this.dado = dado;
        this.rutaLadron = new LinkedList<>();
        this.pistasDelLadron = new ArrayList<>();
        this.ciudades = null;
        this.mapa = null;
        this.destinosEquivocados = new Stack<>();
        this.ladrones = null;
        this.objetosRobados = null;
        this.ladrones = cargarLadrones();
        cargarCiudades();
        cargarDestinos();
        cargarObjetosRobados();
        cargarMapa();


        this.comisaria = new Comisaria(this.ladrones);

    }

    private void cargarDestinos() throws IOException {

        this.inicializadorDeArchivos.cargarDestinos(this.ciudades);

    }

    private void cargarMapa() throws IOException {

        this.mapa = this.inicializadorDeArchivos.cargarMapa(this.ciudades);

    }

    private void cargarPistasDescripcionLadron() throws IOException {

        this.pistasDelLadron = this.inicializadorDeArchivos.cargarPistasDescripcionLadron(this.ladron);
    }

    private void cargarPistasLugares() throws IOException {

        this.ciudades = this.inicializadorDeArchivos.cargarPistasLugares(this.ciudades, this.pistasDelLadron);

    }

    private List<Ladron> cargarLadrones() throws IOException {

        return this.inicializadorDeArchivos.cargarLadrones();

    }

    private void cargarCiudades() throws IOException {

        this.ciudades = this.inicializadorDeArchivos.cargarCiudades();

    }

    private void cargarObjetosRobados() throws IOException {

        this.objetosRobados = this.inicializadorDeArchivos.cargarObjetosRobados(this.ciudades);

    }

    private GradoDePolicia asignarGradoDePolicia(int cantidadDeArrestos) {

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

    private Ladron seleccionarLadron(ObjetoRobado objetoRobado) throws IOException {

        //Seleccionar ladron seteando el objeto robado

        Ladron ladron = ladrones.get(dado.nextInt(ladrones.size()));
        ladron.asignarObjetoRobado(objetoRobado);
        this.establecerRutaDeLadron(objetoRobado);
        return ladron;

    }

    public List<String> getListaDestinos(){
        List<String> destinos = this.policia.obtenerCiudadActual().getListaDestinos();
        if (!destinosEquivocados.isEmpty()){
            int eliminarOpcionAlAzar = this.dado.nextInt(destinos.size());
            destinos.add(destinosEquivocados.peek());
            destinos.remove(eliminarOpcionAlAzar);
        }
        return destinos;
    }

    private void establecerRutaDeLadron(ObjetoRobado objetoRobado){
        Ciudad ciudadInicial = this.policia.obtenerCiudadActual();
        rutaLadron.add(ciudadInicial);
        Integer numeroDePaises = objetoRobado.cantidadPaises();
        List<String> nombresCiudades = this.obtenerNombresDeCiudades(ciudadInicial);

        for (int i = 1;i<=numeroDePaises;i++){
            int numeroCiudadSorteada = dado.nextInt(nombresCiudades.size());
            Ciudad ciudadSorteada = this.ciudades.get(nombresCiudades.get(numeroCiudadSorteada));
            rutaLadron.add(ciudadSorteada);
        }
    }

    private List<String> obtenerNombresDeCiudades(Ciudad ciudadInicial) {
        List<String> nombreCiudades = new ArrayList<>();
        this.ciudades.forEach((k,v) -> {if(v!=ciudadInicial){
            nombreCiudades.add(k);}
        });
        return nombreCiudades;
    }

    public void viajar(String ciudadSeleccionada){

        if (ciudadActual == null) {
            this.ciudadActual = this.rutaLadron.poll();
            this.ciudadSiguiente = this.rutaLadron.poll();
        }

        if ((this.ciudades.get(ciudadSeleccionada) == this.ciudadSiguiente)){
            if(!destinosEquivocados.isEmpty()){
                destinosEquivocados.pop();
            }
            this.ciudadActual = this.ciudades.get(ciudadSeleccionada);
            this.ciudadSiguiente = this.rutaLadron.poll();
        }else{
            this.destinosEquivocados.add(ciudadSeleccionada);
            // ciudadSiguiente vuelve a la ciudadAnterior
            this.ciudadSiguiente = this.ciudadActual;
            this.ciudadSiguiente.setearPistasFalsas();
            this.ciudadActual = this.ciudades.get(ciudadSeleccionada);

        }
        Ciudad ciudad = this.ciudades.get(ciudadSeleccionada);

        this.policia.viajar(ciudad, this.mapa, new Cronometro(this.tiempo));
        this.cantidadDePaisesVisitados++;

        this.policia.dormir(new Cronometro(this.tiempo));

    }

    public Pista entrarEdificio(String lugarSeleccionado) {

        if(this.atrapar()){
            throw new TiempoTerminadoException();
        }
        this.policia.dormir(new Cronometro(this.tiempo));
        Pista pistaObtenida = null;
        int numero = this.dado.nextInt(7);
        if (numero == 5){
            this.acuchillar();
        }
        pistaObtenida = (this.policia.entrarEdificio(new Lugar(lugarSeleccionado), new Cronometro(this.tiempo),this.dado));
        return pistaObtenida;
    }

    private void acuchillar() {
        this.policia.recibirCuchillazo(new Cronometro(this.tiempo));
    }

    public void nuevoCaso(int cantidadDeArrestos) throws IOException {

        GradoDePolicia grado = asignarGradoDePolicia(cantidadDeArrestos);
        ObjetoRobado objetoRobado = seleccionarObjetoRobado(grado);
        this.policia = this.inicializarPolicia(objetoRobado,grado);
        this.ladron = seleccionarLadron(objetoRobado);

        cargarPistasDescripcionLadron();
        cargarPistasLugares();

    }

    public List<String> mostrarLugares(){
        return this.policia.obtenerCiudadActual().getListaLugares();
    }

    public void anotarCualidad(String atributo) {
        Cualidad cualidad = new Cualidad(atributo);
        this.policia.anotarCualidad(cualidad);
    }
    public List<Ladron> buscarLadrones(){
        return this.policia.buscarLadrones(this.comisaria);
    }

    private boolean atrapar() {
        return (this.policia.atrapar());
    }

    public String hora() {
        return (this.tiempo.tiempoFormateado());
    }

}