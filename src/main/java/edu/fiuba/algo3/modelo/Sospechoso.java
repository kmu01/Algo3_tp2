package edu.fiuba.algo3.modelo;

public class Sospechoso extends MiembroDeBanda{

    public Sospechoso (ObjetoRobado objetoRobado){

        super();

        this.genero = "";
        this.hobbie = "";
        this.cabello = "";
        this.senia = "";
        this.vehiculo = "";
        this.objetoRobado = objetoRobado;
        this.ciudad = null;

    }

    public void anotarGenero (String genero){
        this.genero = genero;
    }
    public void anotarHobbie (String hobbie){
        this.hobbie = hobbie;
    }
    public void anotarCabello (String cabello){
        this.cabello = cabello;
    }
    public void anotarSenia (String senia){
        this.senia = senia;
    }
    public void anotarVehiculo (String vehiculo){
        this.vehiculo = vehiculo;
    }

}
