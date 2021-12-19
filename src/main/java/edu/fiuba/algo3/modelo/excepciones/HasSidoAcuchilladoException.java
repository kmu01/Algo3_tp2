package edu.fiuba.algo3.modelo.excepciones;

public class HasSidoAcuchilladoException extends RuntimeException {
    private static final String descripcion = "Has sido acuchillado";

    public String descripcion() {
        return descripcion;
    }
}
