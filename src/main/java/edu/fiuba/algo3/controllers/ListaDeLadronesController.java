package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Ladron;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListaDeLadronesController implements Initializable {
    @FXML AnchorPane PanelLista;
    @FXML private Label LabelLadrones;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void mostrarLista(List<Ladron> ladrones){
        this.mostrar();
        String textoAMostrar = "";
        for (Ladron ladron:ladrones) {
            textoAMostrar += ladron.nombreLadron()+"\n";
        }
        LabelLadrones.setText(textoAMostrar);
    }

    public void ocultar() {
        PanelLista.setVisible(false);
    }
    public void mostrar(){
        PanelLista.setVisible(true);
    }
}
