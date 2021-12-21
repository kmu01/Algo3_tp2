package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.tablero.Pista;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MostrarPistaController implements Initializable {
    @FXML private Label LabelPista;
    @FXML private Pane PanelPista;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void mostrarPista(Pista pista) {
        this.LabelPista.setText(pista.descripcion());
    }
    public void ocultar(){
        this.PanelPista.setVisible(false);
    }
    public void mostrar(){
        this.PanelPista.setVisible(true);
    }

}
