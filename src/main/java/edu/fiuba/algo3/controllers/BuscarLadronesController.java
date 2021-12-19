package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Cualidad;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.excepciones.SeEmitioOrdenDeArrestoException;
import javafx.fxml.Initializable;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class BuscarLadronesController implements Initializable {
    private final String RUTA_LADRONES = "src/main/java/edu/fiuba/algo3/modelo/archivos/ladrones.csv";
    @FXML private Pane PanelLadrones;
    @FXML private ComboBox<String> CajaSexo;
    @FXML private ComboBox<String> CajaHobby;
    @FXML private ComboBox<String> CajaPelo;
    @FXML private ComboBox<String> CajaSenia;
    @FXML private ComboBox<String> CajaVehiculo;
    @FXML private Button BotonBuscarLadrones;
    private List<String> listaDeAtributos;
    private ListaDeLadronesController listaDeLadronesController;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            listaDeAtributos = new ArrayList<>();
            Reader in = new FileReader(RUTA_LADRONES);
            Iterable<CSVRecord> texto = null;
            texto = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            for (CSVRecord linea : texto) {
                String sexo = linea.get("Sexo");
                String hobby = linea.get("Hobby");
                String pelo = linea.get("Pelo");
                String senia = linea.get("Senia");
                String vehiculo = linea.get("Vehiculo");
                if (!CajaSexo.getItems().contains(sexo)){CajaSexo.getItems().add(sexo);}
                if (!CajaHobby.getItems().contains(hobby)){CajaHobby.getItems().add(hobby);}
                if (!CajaPelo.getItems().contains(pelo)){CajaPelo.getItems().add(pelo);}
                if (!CajaSenia.getItems().contains(senia)){CajaSenia.getItems().add(senia);}
                if (!CajaVehiculo.getItems().contains(vehiculo)){CajaVehiculo.getItems().add(vehiculo);}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ocultar(){
        this.PanelLadrones.setVisible(false);
    }
    public void mostrar(ListaDeLadronesController listarLadronesControlador, Label labelTiempo){
        this.PanelLadrones.setVisible(true);
        this.listaDeLadronesController = listarLadronesControlador;
        labelTiempo.setText(Juego.obtenerInstancia().hora());
    }

    public void enviarDatos(){
        listaDeAtributos.add(CajaSexo.getValue());
        listaDeAtributos.add(CajaPelo.getValue());
        listaDeAtributos.add(CajaHobby.getValue());
        listaDeAtributos.add(CajaSenia.getValue());
        listaDeAtributos.add(CajaVehiculo.getValue());
        for (String atributo:listaDeAtributos) {
            if (atributo != null){
                Juego.obtenerInstancia().anotarCualidad(atributo);
            }
        }
        try {
            List<Ladron> sospechosos = Juego.obtenerInstancia().buscarLadrones();
            listaDeLadronesController.mostrarLista(sospechosos);
        }catch(SeEmitioOrdenDeArrestoException e){

        }

    }
}
