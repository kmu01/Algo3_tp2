package edu.fiuba.algo3.modelo.excepciones;

import javafx.scene.image.Image;

public class TiempoTerminadoException extends RuntimeException {
    private static final String descripcion = "Has perdido el juego!";
    private static final Image imagen = new Image("/fotos/avisos/perdio.png");

    public String descripcion() {
        return this.descripcion;
    }

    public Image imagen(){
        return this.imagen;
    }
}
