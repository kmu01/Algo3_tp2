package edu.fiuba.algo3.modelo.excepciones;

public class HasSidoAcuchilladoException extends JuegoException {
    //private String descripcion = "Has sido acuchillado";
    //private String imagen = "file:src/main/resources/fotos/avisos/cuchillo.png";

    public HasSidoAcuchilladoException(){
        imagen = "file:src/main/resources/fotos/avisos/cuchillo.png";
        descripcion = "Has sido acuchillado";
    }

}
