package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class HerirDeArmaController implements Initializable {
    @FXML private Label LabelAvisoDeHerida;
    /*@FXML private Button botonAceptar;*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void mostrarDanio(String descripcion) {
        this.LabelAvisoDeHerida.setText(descripcion);
    }

    public void aceptar() {
        CargadorDeEscena.cargarEscena("/fxml/mostrarTablero.fxml", App.devolverEscena(),"AlgoThief");
    }
}
