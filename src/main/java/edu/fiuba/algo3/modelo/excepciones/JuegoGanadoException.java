package edu.fiuba.algo3.modelo.excepciones;

public class JuegoGanadoException extends JuegoException {

    //private String descripcion = "Has ganado el juego!";
    //private String imagen = "file:src/main/resources/fotos/avisos/trofeo.png";

    public JuegoGanadoException(){
        imagen = "file:src/main/resources/fotos/avisos/trofeo.png";
        descripcion = "Has ganado el juego!";
    }


}
