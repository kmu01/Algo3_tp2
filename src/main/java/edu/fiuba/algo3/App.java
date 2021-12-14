package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.CargadorDeEscena;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.net.URL;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Stage stage;
    private static App app;

    public static App getInstance() {
        if (app == null) {
            app = new App();
        }
        return app;
    }


    @Override
    public void start(Stage stage) {
        CargadorDeEscena.cargarEscena("pantallaDeInicio.fxml", stage, "AlgoThief");
    }

    public static Stage devolverEscena() {
        return stage;
    }

    public static void main(String[] args) {
        launch();
    }

}