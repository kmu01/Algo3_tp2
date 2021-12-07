package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.*;

public class Partida {

    private Policia policia;
    private Comisaria comisaria;
    private Ladron ladron;
    private Tiempo tiempo;
    private Mapa mapa;
    private List<Ladron> ladrones;
    private Map<String,Ciudad> ciudades;
    private List<String> pistasDelLadron;
    private List<ObjetoRobado> objetosRobados;
    private final String RUTA_PISTAS_LUGARES = "src/main/java/edu/fiuba/algo3/modelo/archivos/pistasDeCiudades.csv";
    private final String RUTA_PISTAS_LADRONES = "src/main/java/edu/fiuba/algo3/modelo/archivos/pistasLadrones.csv";
    private final String RUTA_CIUDADES = "src/main/java/edu/fiuba/algo3/modelo/archivos/ciudades.csv";
    private final String RUTA_LADRONES = "src/main/java/edu/fiuba/algo3/modelo/archivos/ladrones.csv";
    private final String RUTA_OBJETOS = "src/main/java/edu/fiuba/algo3/modelo/archivos/objetos.csv";

    public Partida() {

        this.pistasDelLadron = new ArrayList<>();
        this.ciudades = new HashMap<>();
        this.mapa = new Mapa();
        this.ladrones = new ArrayList<>();
        this.objetosRobados = new ArrayList<>();
        cargarLadrones();
        cargarCiudades();
        cargarPistasLugares();
        cargarLadrones();
        this.comisaria = new Comisaria(this.ladrones);
        cargarObjetosRobados();

        GradoDePolicia grado = pedirDatosDelJugador();
        ObjetoRobado objetoRobado = seleccionarObjetoRobado(grado);
        Ciudad ciudadInicial = seleccionarCiudadInicial(objetoRobado);
        this.ladron = seleccionarLadron(objetoRobado);
        cargarPistasDescripcionLadron();


        this.policia = new Policia(new Sospechoso(), grado, ciudadInicial);
        this.tiempo = new Tiempo();
    }

    //Cargar datos
    private void cargarPistasDescripcionLadron(){
        try{
            Reader in = new FileReader(RUTA_PISTAS_LADRONES);
            Iterable<CSVRecord> texto = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            for (CSVRecord linea:texto) {
                String descripcion = linea.get("Pista");
                String ladron = linea.get("Ladron");
                if (ladron.equals(this.ladron)){
                    this.pistasDelLadron.add(descripcion);
                }

            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void cargarPistasLugares(){
        try{
            Reader in = new FileReader(RUTA_PISTAS_LUGARES);
            Iterable<CSVRecord> texto = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            for (CSVRecord linea:texto) {
                String descripcion = linea.get("Pista");
                String ciudad = linea.get("Ciudad");
                String dificultad = linea.get("Dificultad");
                String lugar = linea.get("Lugar");

                Pista pista = new Pista(new Dificultad(dificultad),descripcion,lugar);
                Ciudad ciudadActual = this.ciudades.get(ciudad);
                ciudadActual.agregarPista(pista);

            }
            System.out.println("Cargo las pistas de lugares");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void cargarLadrones(){
        try {
            Reader in = new FileReader(RUTA_LADRONES);
            Iterable<CSVRecord> texto = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            for (CSVRecord linea : texto) {
                String nombre = linea.get("Nombre");
                String sexo = linea.get("Sexo");
                String hobby = linea.get("Hobby");
                String pelo = linea.get("Pelo");
                String senia = linea.get("Senia");
                String vehiculo = linea.get("Vehiculo");
                Ladron actual = new Ladron(nombre, sexo, hobby, pelo, senia, vehiculo);
                ladrones.add(actual);
            }
            System.out.println("Cargo los ladrones");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarCiudades(){
        try {
            Reader in = new FileReader(RUTA_CIUDADES);
            Iterable<CSVRecord> texto = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            for (CSVRecord linea : texto) {
                String nombreCiudad = linea.get("Ciudad");
                float latitud = Float.parseFloat(linea.get("Latitud"));
                float longitud = Float.parseFloat(linea.get("Longitud"));
                Ciudad actual = new Ciudad(nombreCiudad);
                this.ciudades.put(nombreCiudad, actual);
                this.mapa.agregarCiudad(actual, latitud, longitud);
            }
            System.out.println("Cargo las ciudades");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarObjetosRobados(){
        try {
            Reader in = new FileReader(RUTA_OBJETOS);
            Iterable<CSVRecord> texto = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            for (CSVRecord linea : texto) {
                String tesoro = linea.get("Tesoro");
                String ciudad = linea.get("Ciudad");
                String valor = linea.get("Valor");
                ObjetoRobado actual = null;
                Ciudad ciudadInicial = ciudades.get(ciudad);
                if (valor.equals("Comun")){
                    actual = new ObjetoComun(tesoro,ciudadInicial);
                }
                else if (valor.equals("Valioso")){
                    actual = new ObjetoValioso(tesoro,ciudadInicial);
                }
                else {
                    actual = new ObjetoMuyValioso(tesoro,ciudadInicial);
                }
                this.objetosRobados.add(actual);
            }
            System.out.println("Cargo los objetos robados");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GradoDePolicia pedirDatosDelJugador() {
        //Pedir datos y determinar el grado

        return new Novato();
    }


    private ObjetoRobado seleccionarObjetoRobado(GradoDePolicia grado){
        //Seleccionar el objeto en base del grado del policia
        ObjetoRobado obj = grado.elegirObjeto(objetosRobados);
        return new ObjetoComun("Nombre del objeto robado");
    }

    private Ciudad seleccionarCiudadInicial(ObjetoRobado objetoRobado) {
        //Seleccionar ciudad donde comienza el policia

        return objetoRobado.ciudad();

    }

    private Ladron seleccionarLadron(ObjetoRobado objetoRobado) {
        //Seleccionar ladron seteando el objeto robado

        return new Ladron("nombre","genero", "hobbie", "cabello", "senia", "vehiculo");

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