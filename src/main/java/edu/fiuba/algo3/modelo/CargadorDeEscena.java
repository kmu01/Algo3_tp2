package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class CargadorDeEscena {

    private  CargadorDeEscena() {
    }

    private static Parent cargarArchivo(String escena){

        URL root = App.class.getResource(escena);
        System.out.println(root);
        FXMLLoader loader = new FXMLLoader(root);
        Parent mainNode = null;
        //loader.setLocation(root);
        try{
            mainNode = loader.load();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return mainNode;
    }

    public static void cargarEscena(String escena,Stage stage, String titulo){
        Scene scene = new Scene(CargadorDeEscena.cargarArchivo(escena));
        stage.setScene(scene);
        if(!titulo.isBlank()){
            stage.setTitle(titulo);
        }
        //stage.getIcons().add(new Image(Objects.requireNonNull(App.class.getResourceAsStream("/images/logoYetem.png"))));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.sizeToScene();
        stage.show();

    }
}
