package edu.fiuba.algo3.modelo.excepciones;

public abstract class JuegoException extends RuntimeException{

    protected String descripcion;
    protected String imagen;

    public String descripcion(){
        return this.descripcion;
    }

    public String imagen(){
        return this.imagen;
    }
}
