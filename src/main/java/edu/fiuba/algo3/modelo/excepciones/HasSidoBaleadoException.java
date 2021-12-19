package edu.fiuba.algo3.modelo.excepciones;

import javafx.scene.image.Image;

public class HasSidoBaleadoException extends RuntimeException {
    private static final String descripcion = "Has sido baleado";
    private static final Image imagen = new Image("file:src/main/resources/fotos/avisos/pistola.png");

    public String descripcion() {
        return this.descripcion;
    }

    public Image imagen(){
        return this.imagen;
    }
}
