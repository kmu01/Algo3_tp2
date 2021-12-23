package edu.fiuba.algo3.modelo.excepciones;

public class NoTieneOrdenDeArrestoException extends JuegoException {

    public NoTieneOrdenDeArrestoException(){
        imagen = "file:src/main/resources/fotos/avisos/perdio.png";
        descripcion = "No tienes orden de arresto";
    }

}
