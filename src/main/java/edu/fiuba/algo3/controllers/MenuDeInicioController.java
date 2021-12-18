package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuDeInicioController implements Initializable {
    @FXML public AnchorPane bc;
    public void comenzar(){
        CargadorDeEscena.cargarEscena("/fxml/pedirCantidadDeArrestos.fxml", App.devolverEscena(),"AlgoThief");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void salir(){ App.devolverEscena().close(); }

    public void playMusic() { AudioController.getInstance().play(); }
}
