package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pista;
import edu.fiuba.algo3.modelo.excepciones.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class TableroController implements Initializable{
    @FXML private Pane PanelAcciones;
    @FXML private GridPane GridPanePrincipal;
    @FXML private HBox CajaViaje;
    @FXML private HBox CajaVisita;
    @FXML private Button BotonLugar1;
    @FXML private Button BotonLugar2;
    @FXML private Button BotonLugar3;
    @FXML private ImageView ImagenLugar1;
    @FXML private ImageView ImagenLugar2;
    @FXML private ImageView ImagenLugar3;
    @FXML private Button BotonViajar1;
    @FXML private Button BotonViajar2;
    @FXML private Button BotonViajar3;
    @FXML private Label LabelTiempo;
    @FXML private Label LabelCiudad;
    @FXML private Label LabelBienvenida;

    private MostrarPistaController pistaControlador;
    private FotoDeCiudadController fotoDeCiudadControlador;
    private BuscarLadronesController buscarLadronesControlador;
    private ListaDeLadronesController listarLadronesControlador;
    private ExceptionController exceptionControlador;
    private final String URL_ICONOS = "file:src/main/resources/fotos/iconos/";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LabelTiempo.setText(Juego.obtenerInstancia().hora());
        String ciudadInicio = Juego.obtenerInstancia().getCiudadActual().ciudad();
        LabelCiudad.setText(ciudadInicio);
        LabelBienvenida.setText("Bienvenido "+Juego.obtenerInstancia().getGrado()+"." +
                " Su objetivo es capturar al ladrón que se robó el tesoro de "+ ciudadInicio +".");
        try {
            this.cargarPistas();
            this.cargarImagen();
            this.cargarLadrones();
            this.cargarListarLadrones();
            this.cargarExcepcion();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarListarLadrones() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mostrarListaDeLadrones.fxml"));
        Parent mainNode = loader.load();
        listarLadronesControlador = loader.getController();
        Pane seccion = new Pane(mainNode);
        GridPanePrincipal.add(seccion, 0, 0);
        listarLadronesControlador.ocultar();
    }

    private void cargarLadrones() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/buscarLadrones.fxml"));
        Parent mainNode = loader.load();
        buscarLadronesControlador = loader.getController();
        Pane seccion = new Pane(mainNode);
        GridPanePrincipal.add(seccion, 1, 0);
        buscarLadronesControlador.ocultar();
    }

    private void cargarPistas() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mostrarPista.fxml"));
        Parent mainNode = loader.load();
        pistaControlador = loader.getController();
        Pane seccion = new Pane(mainNode);
        GridPanePrincipal.add(seccion, 1, 0);
        pistaControlador.ocultar();
    }

    private void cargarImagen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mostrarFotoCiudad.fxml"));
        Parent mainNode = loader.load();
        fotoDeCiudadControlador = loader.getController();
        Pane seccion = new Pane(mainNode);
        GridPanePrincipal.add(seccion, 0, 0);
        fotoDeCiudadControlador.mostrarImagen(Juego.obtenerInstancia().getCiudadActual().ciudad());
    }

    public void entrarAEdificio(){
        listarLadronesControlador.ocultar();;
        PanelAcciones.setVisible(true);
        CajaViaje.setVisible(false);
        CajaVisita.setVisible(true);
        List<String> lugares = Juego.obtenerInstancia().getLugares();
        BotonLugar1.setText((lugares.get(0)));
        ImagenLugar1.setImage(new Image(URL_ICONOS+lugares.get(0)+".png"));
        BotonLugar2.setText((lugares.get(1)));
        ImagenLugar2.setImage(new Image(URL_ICONOS+lugares.get(1)+".png"));
        BotonLugar3.setText((lugares.get(2)));
        ImagenLugar3.setImage(new Image(URL_ICONOS+lugares.get(2)+".png"));
    }


    public void mostrarPistaLugar1() {
        this.mostrarPista(BotonLugar1);
        LabelTiempo.setText(Juego.obtenerInstancia().hora());
    }
    public void mostrarPistaLugar2() {
        this.mostrarPista(BotonLugar2);
        LabelTiempo.setText(Juego.obtenerInstancia().hora());
    }
    public void mostrarPistaLugar3() {
        this.mostrarPista(BotonLugar3);
        LabelTiempo.setText(Juego.obtenerInstancia().hora());
    }

    public void cargarExcepcion () throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mostrarExcepciones.fxml"));
        Parent mainNode = loader.load();
        exceptionControlador = loader.getController();
        Pane seccion = new Pane(mainNode);
        GridPanePrincipal.add(seccion, 0, 0);
        exceptionControlador.ocultar();

    }

    public void mostrarPista(Button boton) {
        try {
            Pista pista = Juego.obtenerInstancia().entrarEdificio(boton.getText());
            PanelAcciones.setVisible(false);
            fotoDeCiudadControlador.mostrarImagen(Juego.obtenerInstancia().getCiudadActual().ciudad());
            fotoDeCiudadControlador.mostrar();
            pistaControlador.mostrar();
            buscarLadronesControlador.ocultar();
            pistaControlador.mostrarPista(pista);
        } catch (JuegoException e) {
            exceptionControlador.mostrar(e.descripcion(), e.imagen(), e);
            PanelAcciones.setVisible(false);

        }


    }
    public void viajar(){
        PanelAcciones.setVisible(true);
        CajaViaje.setVisible(true);
        CajaVisita.setVisible(false);
        buscarLadronesControlador.ocultar();;
        List<String> destinos = Juego.obtenerInstancia().getDestinos();
        BotonViajar1.setText(destinos.get(0));
        BotonViajar2.setText(destinos.get(1));
        BotonViajar3.setText(destinos.get(2));

    }

    public void viajarDestino1(){
        this.volar(BotonViajar1);
    }

    public void volar(Button botonSeleccionado){
        try {
            int tiempoTranscurrido = Juego.obtenerInstancia().viajar(botonSeleccionado.getText());
            listarLadronesControlador.ocultar();
            PanelAcciones.setVisible(false);
            LabelTiempo.setText(Juego.obtenerInstancia().hora());
            String ciudadActual = Juego.obtenerInstancia().getCiudadActual().ciudad();
            LabelCiudad.setText(ciudadActual);
            LabelBienvenida.setText("Bienvenido a " + ciudadActual + ". Su vuelo a durado "+ tiempoTranscurrido + "hs.");
            fotoDeCiudadControlador.mostrarImagen(ciudadActual);
            fotoDeCiudadControlador.mostrar();
            pistaControlador.ocultar();
        }catch(TiempoTerminadoException e){

        }


    }

    public void viajarDestino2(){
        this.volar(BotonViajar2);
    }

    public void viajarDestino3(){
        this.volar((BotonViajar3));
    }

    public void entrarAComisaria(){
        listarLadronesControlador.ocultar();
        PanelAcciones.setVisible(false);
        fotoDeCiudadControlador.ocultar();
        pistaControlador.ocultar();
        buscarLadronesControlador.mostrar(listarLadronesControlador,LabelTiempo);

    }


}
