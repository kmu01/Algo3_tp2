package edu.fiuba.algo3.controllers;

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
    @FXML private Pane PanelAviso;
    @FXML private Button BotonAviso;
    //private String URL_AVISOS = "file:src/main/resources/fotos/avisos/";
    private Image img;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void mostrar(String descripcion, String aviso) {
        System.out.println(aviso);
        img = new Image(aviso);
        ImagenAviso.setImage(img);
        this.LabelAviso.setText(descripcion);
        this.PanelAviso.setVisible(true);
    }
    public void aceptar() {
        this.ocultar();
    }

    public void ocultar() {
        PanelAviso.setVisible(false);
    }
}
