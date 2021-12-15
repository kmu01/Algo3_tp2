package edu.fiuba.algo3;

import edu.fiuba.algo3.controllers.CargadorDeEscena;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Stage stage;
    private static App app;

    public static App getInstance(){
        if(app == null){
            app = new App();
        }
        return app;
    }


    @Override
    public void start(Stage stage){
        App.stage = stage;
        CargadorDeEscena.cargarEscena("/fxml/pantallaDeInicio.fxml",stage,"AlgoThief");
    }

    public static Stage devolverEscena(){
        return stage;
    }

    public static void main(String[] args) {
        launch();
    }

    public void abrirReglas() throws URISyntaxException {
        URL url = getClass().getResource("");
        assert url != null;

        File file = new File(url.toURI());
        HostServices hostServices = App.getInstance().getHostServices();
        hostServices.showDocument(file.getAbsolutePath());
    }

    public static void acercaDe(){
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