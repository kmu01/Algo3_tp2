package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.InicializadorDeArchivos;
import edu.fiuba.algo3.modelo.Partida;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class MenuDeCantidadDeArrestosController implements Initializable {
    @FXML private TextField cantidadDeArrestos;
    @FXML private Label datosCargados;

    public MenuDeCantidadDeArrestosController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void iniciarJuego(){
        try {
            Partida partida = new Partida(new InicializadorDeArchivos(),new Random());
            Integer numero = Integer.parseInt(cantidadDeArrestos.getText());
            partida.nuevoCaso(numero);

            CargadorDeEscena.cargarEscena("/fxml/mostrarTablero.fxml", App.devolverEscena(),"AlgoThief");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
