package edu.fiuba.algo3.modelo;

public class Pista {
    private NivelDePista nivel;
    private String descripcion;
    private String lugarCorrespondiente;
    private int cantDeVisitas;

    public Pista(NivelDePista nivel,String descripcion, String lugarCorrespondiente){
        this.cantDeVisitas = 0;
        this.nivel = nivel;
        this.descripcion = descripcion;
        this.lugarCorrespondiente = lugarCorrespondiente;
    }

    public boolean esPista(NivelDePista nivel ,String nombreLugar){

        return ((this.nivel.esNivel(nivel)) && (this.lugarCorrespondiente.equals(nombreLugar)));

    }

    private void calcularTiempoEnObtenerLaPista (Cronometro cronometro){

        cronometro.calcularTiempoEnObtenerLaPista(this.cantDeVisitas);

    }

    public Pista obtenerPista(Cronometro cronometro){
        this.cantDeVisitas++;
        this.calcularTiempoEnObtenerLaPista(cronometro);
        return this;
    }

    public String descripcion (){

        return this.descripcion;

    }

}
