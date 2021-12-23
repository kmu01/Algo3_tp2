package edu.fiuba.algo3.modelo.excepciones;

public class JuegoGanadoException extends JuegoException {

    public JuegoGanadoException(){
        imagen = "file:src/main/resources/fotos/avisos/esposas.png";
        descripcion = "Felicidades, arrestaste al ladron!";
    }

}
