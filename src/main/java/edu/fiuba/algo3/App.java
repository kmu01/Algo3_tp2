package edu.fiuba.algo3;

import edu.fiuba.algo3.controllers.AudioController;
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
        AudioController.getInstance();
    }

    public static Stage devolverEscena(){
        return stage;
    }

    public static void main(String[] args) {
        launch();
    }



}