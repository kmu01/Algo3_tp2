package edu.fiuba.algo3.modelo;

public class Pista {
    private Dificultad dificultad;
    private String descripcion;
    private String lugarCorrespondiente;
    private int cantDeVisitas;

    public Pista(Dificultad dificultad, String descripcion, String lugarCorrespondiente){
        this.cantDeVisitas = 0;
        this.dificultad = dificultad;
        this.descripcion = descripcion;
        this.lugarCorrespondiente = lugarCorrespondiente;
    }

    public boolean esPista(Dificultad dificultad, String nombreLugar){

        return ((this.dificultad.obtenerDificultad().equals(dificultad.obtenerDificultad())) && (this.lugarCorrespondiente.equals(nombreLugar)));

    }

    private void calcularTiempoEnObtenerLaPista (Cronometro cronometro){

        cronometro.calcularTiempoEnObtenerLaPista(this.cantDeVisitas);

    }

    public Pista obtenerPista(Cronometro cronometro){
        ++this.cantDeVisitas;
        this.calcularTiempoEnObtenerLaPista(cronometro);
        return this;
    }

    public String descripcion (){

        return this.descripcion;

    }

}
