package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.App;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorMenuInicio implements Initializable {
    @FXML public AnchorPane bc;
    public void comenzar(){
        CargadorDeEscena.cargarEscena("/fxml/pedirCantidadDeArrestos.fxml", App.devolverEscena(),"AlgoThief");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void salir(){ App.devolverEscena().close(); }

    public void backMusic() { ControladorAudio.getInstance().back(); }

    public void playMusic() { ControladorAudio.getInstance().play(); }

    public void skipMusic() { ControladorAudio.getInstance().skip(); }

    public void abrirReglas() throws URISyntaxException {
        URL url = getClass().getResource("/archivos/reglas.pdf");
        assert url != null;

        File file = new File(url.toURI());
        HostServices hostServices = App.getInstance().getHostServices();
        hostServices.showDocument(file.getAbsolutePath());
    }


    public void acercaDe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("Acerca de la aplicacion");
        String mensaje = "AlgoThief es un juego inspirado en 'Where in the world is Carmen Sandiego?' y desarrollado en Java, basandose en el conocimiento adquirido a lo largo" +
                " del segundo cuatrimestre de 2021 de Algoritmos y Programación III\n\n" +
                " Integrantes: \n" +
                "\t\t\t> Federico Camurri \n" +
                "\t\t\t> Martín Reimundo \n" +
                "\t\t\t> Nicolás Martino\n" +
                "\t\t\t> Carlos Orqueda\n" +
                "\t\t\t> Enrique Morici\n";
        alert.setContentText(mensaje);
        alert.show();
    }
}
