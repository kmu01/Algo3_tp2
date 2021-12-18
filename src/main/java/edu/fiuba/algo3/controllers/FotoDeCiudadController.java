package edu.fiuba.algo3.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class FotoDeCiudadController implements Initializable {
    @FXML private ImageView ImagenPais;
    private String URL_PAISES = "file:src/main/resources/fotos/paises/";
    private Image img;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void mostrarImagen(String ciudad){
        img = new Image(URL_PAISES+ciudad+".jpg");
        ImagenPais.setImage(img);
    }
}
