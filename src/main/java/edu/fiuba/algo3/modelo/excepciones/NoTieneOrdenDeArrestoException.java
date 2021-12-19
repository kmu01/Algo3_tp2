package edu.fiuba.algo3.modelo.excepciones;

import javafx.scene.image.Image;

public class NoTieneOrdenDeArrestoException extends RuntimeException {
    private static final String descripcion = "No tienes orden de arresto";
    private static final Image imagen = new Image("file:src/main/resources/fotos/avisos/perdio.png");

    public String descripcion() {
        return this.descripcion;
    }

    public Image imagen(){
        return this.imagen;
    }


}
