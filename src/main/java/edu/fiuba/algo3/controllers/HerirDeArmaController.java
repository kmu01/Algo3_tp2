package edu.fiuba.algo3.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class HerirDeArmaController implements Initializable {
    @FXML private Label LabelAvisoDeHerida;
    @FXML private Pane PanelHerida;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void mostrar(String descripcion) {
        this.LabelAvisoDeHerida.setText(descripcion);
    }

}
