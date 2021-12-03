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
        return ((this.nivel == nivel) && (nombreLugar == this.lugarCorrespondiente));
    }


    public Evidencia pedirEvidencia(){
        this.cantDeVisitas++;
        Evidencia evidencia = new Evidencia();
        evidencia.entradaAlEdificio(this.cantDeVisitas,this);
        return evidencia;
    }
}
