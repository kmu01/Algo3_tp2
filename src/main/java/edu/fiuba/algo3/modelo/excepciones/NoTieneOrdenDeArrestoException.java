package edu.fiuba.algo3.modelo.excepciones;

public class NoTieneOrdenDeArrestoException extends JuegoException {
    //private String descripcion = "No tienes orden de arresto";
    //private String imagen = "file:src/main/resources/fotos/avisos/perdio.png";

    public NoTieneOrdenDeArrestoException(){
        imagen = "file:src/main/resources/fotos/avisos/perdio.png";
        descripcion = "No tienes orden de arresto";
    }


}
