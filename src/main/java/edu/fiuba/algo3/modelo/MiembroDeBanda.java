package edu.fiuba.algo3.modelo;

public abstract class MiembroDeBanda {

    protected String nombre;
    protected String genero;
    protected String hobbie;
    protected String cabello;
    protected String senia;
    protected String vehiculo;
    protected ObjetoRobado objetoRobado;
    protected Ciudad ciudad;

    public MiembroDeBanda (){}

    public ObjetoRobado objetoRobado (){

        return objetoRobado;

    }

    public Ciudad ciudadActual (){
        return this.ciudad;
    }

}
