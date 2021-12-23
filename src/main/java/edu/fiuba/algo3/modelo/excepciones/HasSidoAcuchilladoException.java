package edu.fiuba.algo3.modelo.excepciones;

public class HasSidoAcuchilladoException extends JuegoException {

    public HasSidoAcuchilladoException(){
        imagen = "file:src/main/resources/fotos/avisos/cuchillo.png";
        descripcion = "Has sido acuchillado";
    }

}
