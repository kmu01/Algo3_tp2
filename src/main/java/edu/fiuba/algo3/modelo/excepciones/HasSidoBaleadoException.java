package edu.fiuba.algo3.modelo.excepciones;


public class HasSidoBaleadoException extends JuegoException {
    //private String descripcion = "Has sido baleado";
    //private imagen = "file:src/main/resources/fotos/avisos/pistola.png";

    public HasSidoBaleadoException(){
        imagen = "file:src/main/resources/fotos/avisos/pistola.png";
        descripcion = "Has sido baleado";
    }


}
