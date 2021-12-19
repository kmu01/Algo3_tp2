package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ExceptionController implements Initializable {
    @FXML private Label LabelAviso;
    @FXML private ImageView ImagenAviso;
    private String URL_AVISOS = "file:src/main/resources/fotos/avisos/";
    private Image img;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void mostrar(String descripcion, Image aviso) {
        this.LabelAviso.setText(descripcion);
        ImagenAviso.setImage(aviso);
    }
    public void aceptar() {
        CargadorDeEscena.cargarEscena("/fxml/mostrarTablero.fxml", App.devolverEscena(),"AlgoThief");
    }
}
