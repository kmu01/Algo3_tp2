package edu.fiuba.algo3.modelo.excepciones;

public class TiempoTerminadoException extends JuegoException {

    public TiempoTerminadoException(){
        imagen = "file:src/main/resources/fotos/avisos/perdio.png";
        descripcion = "Has perdido el juego!";
    }

}
