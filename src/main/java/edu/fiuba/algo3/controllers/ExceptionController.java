package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.excepciones.JuegoException;
import edu.fiuba.algo3.modelo.excepciones.JuegoGanadoException;
import edu.fiuba.algo3.modelo.excepciones.TiempoTerminadoException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    private Image img;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void mostrar(String descripcion, String aviso, JuegoException e) {
        img = new Image(aviso);
        ImagenAviso.setImage(img);
        this.LabelAviso.setText(descripcion);
        this.PanelAviso.setVisible(true);
        if ((e.getClass() == TiempoTerminadoException.class || e.getClass() == JuegoGanadoException.class)) {
            BotonAviso.setOnAction(event -> {
                Juego.obtenerInstancia().resetear();
                CargadorDeEscena.cargarEscena("/fxml/pedirCantidadDeArrestos.fxml", App.devolverEscena(),"AlgoThief");
            });
        } else {
            BotonAviso.setOnAction(event -> this.ocultar());
        }
    }

    public void ocultar() {
        PanelAviso.setVisible(false);
    }
}
