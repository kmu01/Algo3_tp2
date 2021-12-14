package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuDeInicioController implements Initializable {
    @FXML public AnchorPane bc;
    public void comenzar(){
        CargadorDeEscena.cargarEscena("/fxml/pedirCantidadDeArrestos.fxml", App.devolverEscena(),"Cantidad de arrestos");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
