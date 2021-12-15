package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Pista;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class TableroController implements Initializable {
    @FXML private Button BotonLugar1;
    @FXML private Button BotonLugar2;
    @FXML private Button BotonLugar3;
    @FXML private Button BotonViajar1;
    @FXML private Button BotonViajar2;
    @FXML private Button BotonViajar3;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void entrarAEdificio(){
        BotonViajar1.setVisible(false);
        BotonViajar2.setVisible(false);
        BotonViajar3.setVisible(false);
        BotonLugar1.setVisible(true);
        BotonLugar2.setVisible(true);
        BotonLugar3.setVisible(true);
    }
    public void entraPrimerLugar(){
    }
    public void entraSegundoLugar(){
    }
    public void entraTercerLugar(){}

    public void mostrarPista(){
        //Pista pista = Juego.obtenerInstancia().entrarEdificio();
    }

    public void viajar(){
        BotonLugar1.setVisible(false);
        BotonLugar2.setVisible(false);
        BotonLugar3.setVisible(false);
        BotonViajar1.setVisible(true);
        BotonViajar2.setVisible(true);
        BotonViajar3.setVisible(true);
    }

}
