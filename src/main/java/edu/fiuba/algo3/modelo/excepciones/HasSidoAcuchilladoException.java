package edu.fiuba.algo3.modelo.excepciones;

import javafx.scene.image.Image;

public class HasSidoAcuchilladoException extends RuntimeException {
    private static final String descripcion = "Has sido acuchillado";
    private static final Image imagen = new Image("file:src/main/resources/fotos/avisos/cuchillo.png");

    public String descripcion() {
        return this.descripcion;
    }

    public Image imagen(){
        return this.imagen;
    }
}
