package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pista;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MostrarPistaController implements Initializable {
    @FXML private Label LabelPista;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public MostrarPistaController(){}

    public void mostrarPista(Pista pista) {
        this.LabelPista.setText(pista.descripcion());
    }
}
