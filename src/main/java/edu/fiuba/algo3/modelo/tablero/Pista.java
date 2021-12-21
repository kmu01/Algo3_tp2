package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.ubicacion.Cronometro;

public class Pista {

    private Dificultad dificultad;
    private String descripcion;
    private String descripcionLadron;
    private String lugarCorrespondiente;
    private int cantDeVisitas;

    public Pista(Dificultad dificultad, String descripcion, String lugarCorrespondiente){
        this.cantDeVisitas = 0;
        this.dificultad = dificultad;
        this.descripcion = descripcion;
        this.lugarCorrespondiente = lugarCorrespondiente;
        this.descripcionLadron = "";
    }

    public boolean esPista(Dificultad dificultad, String nombreLugar){

        return ((this.dificultad.esDificultad(dificultad)) && (this.lugarCorrespondiente.equals(nombreLugar)));

    }

    public void asignarPistaDeLadron(String pistaLadron){this.descripcionLadron = pistaLadron;}


    private void calcularTiempoEnObtenerLaPista (Cronometro cronometro) {

        cronometro.calcularTiempoEnObtenerLaPista(this.cantDeVisitas);

    }

    public Pista obtenerPista(Cronometro cronometro) {
        ++this.cantDeVisitas;
        this.calcularTiempoEnObtenerLaPista(cronometro);
        return this;
    }

    public String descripcion(){

        return (this.descripcion +" "+ this.descripcionLadron);
    }

}
