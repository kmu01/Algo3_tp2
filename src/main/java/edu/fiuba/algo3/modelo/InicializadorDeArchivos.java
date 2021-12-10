package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.objetos.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InicializadorDeArchivos {
    private final String RUTA_PISTAS_LUGARES = "src/main/java/edu/fiuba/algo3/modelo/archivos/pistasDeCiudades.csv";
    private final String RUTA_PISTAS_LADRONES = "src/main/java/edu/fiuba/algo3/modelo/archivos/pistasLadrones.csv";
    private final String RUTA_CIUDADES = "src/main/java/edu/fiuba/algo3/modelo/archivos/ciudades.csv";
    private final String RUTA_LADRONES = "src/main/java/edu/fiuba/algo3/modelo/archivos/ladrones.csv";
    private final String RUTA_OBJETOS = "src/main/java/edu/fiuba/algo3/modelo/archivos/objetos.csv";

    public InicializadorDeArchivos() {
    }

    public List<Ladron> cargarLadrones() {
        List<Ladron> ladrones = new ArrayList<>();
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
                List<Cualidad> cualidades = new ArrayList<>();
                cualidades.add(new Cualidad(sexo));cualidades.add(new Cualidad(hobby));cualidades.add(new Cualidad(pelo));
                cualidades.add(new Cualidad(senia));cualidades.add(new Cualidad(vehiculo));
                Ladron actual = new Ladron(nombre, cualidades);
                ladrones.add(actual);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ladrones;
    }

    public Map<String ,Ciudad> cargarCiudades() {
        Map<String,Ciudad> ciudades = new HashMap<>();
        try {
            Reader in = new FileReader(RUTA_CIUDADES);
            Iterable<CSVRecord> texto = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            for (CSVRecord linea : texto) {
                String nombreCiudad = linea.get("Ciudad");
                float latitud = Float.parseFloat(linea.get("Latitud"));
                float longitud = Float.parseFloat(linea.get("Longitud"));
                Ciudad actual = new Ciudad(nombreCiudad);
                ciudades.put(nombreCiudad, actual);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ciudades;

    }
    public Mapa cargarMapa (Map<String,Ciudad>ciudades) {
        Mapa mapa = new Mapa();
        try {
            Reader in = new FileReader(RUTA_CIUDADES);
            Iterable<CSVRecord> texto = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            for (CSVRecord linea : texto) {
                String nombreCiudad = linea.get("Ciudad");
                float latitud = Float.parseFloat(linea.get("Latitud"));
                float longitud = Float.parseFloat(linea.get("Longitud"));
                Ciudad actual = ciudades.get(nombreCiudad);
                mapa.agregarCiudad(actual, latitud, longitud);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapa;
    }

    public Map<String,Ciudad> cargarPistasLugares(Map<String,Ciudad>ciudades){
        try{
            Reader in = new FileReader(RUTA_PISTAS_LUGARES);
            Iterable<CSVRecord> texto = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            for (CSVRecord linea:texto) {
                String descripcion = linea.get("Pista");
                String ciudad = linea.get("Ciudad");
                String dificultad = linea.get("Dificultad");
                String lugar = linea.get("Lugar");

                Pista pista = new Pista(new Dificultad(dificultad),descripcion,lugar);
                Ciudad ciudadActual = ciudades.get(ciudad);
                ciudadActual.agregarPista(pista);

            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return ciudades;
    }

    public List<ObjetoRobado> cargarObjetosRobados(Map<String,Ciudad> ciudades){
        List<ObjetoRobado> objetosRobados = new ArrayList<>();
        try {
            Reader in = new FileReader(RUTA_OBJETOS);
            Iterable<CSVRecord> texto = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            for (CSVRecord linea : texto) {
                String tesoro = linea.get("Tesoro");
                String ciudad = linea.get("Ciudad");
                String valor = linea.get("Valor");
                ObjetoRobado actual = null;
                Ciudad ciudadInicial = ciudades.get(ciudad);
                if(valor.equals("Comun")){
                    actual = new ObjetoComun(tesoro, ciudadInicial);
                }
                else if(valor.equals("Valioso")){
                    actual = new ObjetoValioso(tesoro, ciudadInicial);
                }
                else{
                actual = new ObjetoMuyValioso(tesoro, ciudadInicial);
                }
                objetosRobados.add(actual);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return objetosRobados;
    }

    public List<String> cargarPistasDescripcionLadron(List<String> pistasDelLadron,Ladron ladron){
        try{
            Reader in = new FileReader(RUTA_PISTAS_LADRONES);
            Iterable<CSVRecord> texto = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            for (CSVRecord linea:texto) {
                String descripcion = linea.get("Pista");
                String ladronArchivo = linea.get("Ladron");
                ladron.chequearPistas(pistasDelLadron, descripcion, ladronArchivo);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return pistasDelLadron;
    }

}