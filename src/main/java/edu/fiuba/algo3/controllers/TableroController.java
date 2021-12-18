package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Pista;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
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
    @FXML private Button BotonViajar1;
    @FXML private Button BotonViajar2;
    @FXML private Button BotonViajar3;
    @FXML private Label LabelTiempo;
    @FXML private Label LabelCiudad;

    private MostrarPistaController pistaControlador;
    private FotoDeCiudadController fotoDeCiudadControlador;
    private BuscarLadronesController buscarLadronesControlador;
    private ListaDeLadronesController listarLadronesControlador;
    //todo una forma de hacer lo de la lista ladrones es iniciar el controlador como hice con la foto de ciudad, y mandarselo por
    // parametro en mostrar() de BuscarLadronesController, y cuando apreten buscar en el boton de busqueda de ladrones
    // simplemente este le diga a el controlador de la lista que se muestre.
    // tambien al mostrar la busqueda de ladrones podemos ocultar la ciudad, así es mas facil.

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LabelTiempo.setText(Juego.obtenerInstancia().hora());
        LabelCiudad.setText(Juego.obtenerInstancia().getCiudadActual());
        try {
            this.cargarPistas();
            this.cargarImagen();
            this.cargarLadrones();
            this.cargarListarLadrones();
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
    }

    private void cargarImagen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mostrarFotoCiudad.fxml"));
        Parent mainNode = loader.load();
        fotoDeCiudadControlador = loader.getController();
        Pane seccion = new Pane(mainNode);
        GridPanePrincipal.add(seccion, 0, 0);
        fotoDeCiudadControlador.mostrarImagen(Juego.obtenerInstancia().getCiudadActual());
    }

    public void entrarAEdificio(){
        listarLadronesControlador.ocultar();;
        PanelAcciones.setVisible(true);
        CajaViaje.setVisible(false);
        CajaVisita.setVisible(true);
        List<String> lugares = Juego.obtenerInstancia().getLugares();
        BotonLugar1.setText((lugares.get(0)));
        BotonLugar2.setText((lugares.get(1)));
        BotonLugar3.setText((lugares.get(2)));
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

    public void mostrarPista(Button boton){
        Pista pista = Juego.obtenerInstancia().entrarEdificio(boton.getText());
        PanelAcciones.setVisible(false);
        fotoDeCiudadControlador.mostrarImagen(Juego.obtenerInstancia().getCiudadActual());
        fotoDeCiudadControlador.mostrar();
        pistaControlador.mostrar();
        buscarLadronesControlador.ocultar();
        pistaControlador.mostrarPista(pista);
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
        Juego.obtenerInstancia().viajar(botonSeleccionado.getText());
        listarLadronesControlador.ocultar();
        PanelAcciones.setVisible(false);
        LabelTiempo.setText(Juego.obtenerInstancia().hora());
        LabelCiudad.setText(Juego.obtenerInstancia().getCiudadActual());
        fotoDeCiudadControlador.mostrarImagen(Juego.obtenerInstancia().getCiudadActual());
        fotoDeCiudadControlador.mostrar();
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
