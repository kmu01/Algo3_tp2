package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Juego;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuDeCantidadDeArrestosController implements Initializable {
    @FXML private TextField cantidadDeArrestos;

    public MenuDeCantidadDeArrestosController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void iniciarJuego(){
        try {

            Integer numero = Integer.parseInt(cantidadDeArrestos.getText());
            Juego.obtenerInstancia().nuevoCaso(numero);

            CargadorDeEscena.cargarEscena("/fxml/mostrarTablero.fxml", App.devolverEscena(),"AlgoThief");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
