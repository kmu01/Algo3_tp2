package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Pista;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TableroController implements Initializable {
    @FXML private Pane PanelAcciones;
    @FXML private GridPane GridPanePrincipal;
    @FXML private HBox CajaViaje;
    @FXML private HBox CajaVisita;
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
        PanelAcciones.setVisible(true);
        CajaViaje.setVisible(false);
        CajaVisita.setVisible(true);
        List<String> lugares = Juego.obtenerInstancia().getLugares();
        BotonLugar1.setText((lugares.get(0)));
        BotonLugar2.setText((lugares.get(1)));
        BotonLugar3.setText((lugares.get(2)));
    }

    public void mostrarPistaLugar1(){
        Pista pista = Juego.obtenerInstancia().entrarEdificio(BotonLugar1.getText());
        CargadorDeEscena.cargarPanel("/fxml/mostrarPista.fxml", GridPanePrincipal,1,0);
        PanelAcciones.setVisible(false);
    }
    public void mostrarPistaLugar2(){
        Pista pista = Juego.obtenerInstancia().entrarEdificio(BotonLugar2.getText());
        CargadorDeEscena.cargarPanel("/fxml/mostrarPista.fxml",GridPanePrincipal,1,0);
        PanelAcciones.setVisible(false);
    }
    public void mostrarPistaLugar3(){
        Pista pista = Juego.obtenerInstancia().entrarEdificio(BotonLugar3.getText());
        CargadorDeEscena.cargarPanel("/fxml/mostrarPista.fxml",GridPanePrincipal,1,0);
        PanelAcciones.setVisible(false);
    }

    public void viajar(){
        PanelAcciones.setVisible(true);
        CajaViaje.setVisible(true);
        CajaVisita.setVisible(false);
    }

    public void buscar(){
        PanelAcciones.setVisible(false);
    }

}
