package edu.fiuba.algo3.modelo.excepciones;

public class HasSidoBaleadoException extends RuntimeException {
    private static final String descripcion = "Has sido baleado";
    public String descripcion() {
        return this.descripcion;
    }
}
