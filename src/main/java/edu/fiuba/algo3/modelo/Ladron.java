package edu.fiuba.algo3.modelo;

public class Ladron extends MiembroDeBanda{

    public Ladron (String nombre, String genero, String hobbie, String cabello, String senia, String vehiculo){

        this.cabello = cabello;
        this.hobbie = hobbie;
        this.genero = genero;
        this.senia = senia;
        this.vehiculo = vehiculo;
        this.ciudad = ciudad;

    }

    public void asignarObjetoRobado(ObjetoRobado objeto){
        this.objetoRobado = objeto;
    }

}
