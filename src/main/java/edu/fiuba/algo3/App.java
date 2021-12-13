package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.InicializadorDeArchivos;

import java.io.IOException;
import java.util.Random;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("AlgoThief");
        Pane layout = new Pane();
        Label label = new Label("Bienvenido a AlgoThief!");
        layout.autosize();
        label.setFont(Font.font("Segoe UI Black", 16));

        label.setLayoutX(200);
        label.setLayoutY(200);
        layout.getChildren().add(label);
        Button botonBienvenida = new Button();
        botonBienvenida.setLayoutX(240);
        botonBienvenida.setLayoutY(260);
        botonBienvenida.setText("Empezar partida");

        botonBienvenida.setOnAction(empezar -> {

            try {
                Partida p = new Partida(new InicializadorDeArchivos(), new Random());
                p.pedirDatos();
            }
            catch (IOException e){
                System.out.println("Error al cargar archivos");
            }

        });

        layout.getChildren().add(botonBienvenida);
        Scene scene = new Scene(layout, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}