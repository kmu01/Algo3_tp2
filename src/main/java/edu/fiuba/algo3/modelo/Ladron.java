package edu.fiuba.algo3.modelo;

public class Ladron {
    private String genero;
    private String hobbie;
    private String cabello;
    private String seña;
    private String vehiculo;
    private ObjetoRobado objetoRobado;
    public Ladron(String objetoRobado){

        this.objetoRobado = new ObjetoComun(objetoRobado);
    }

    public Ladron (String objetoRobado, String genero,String hobbie,String cabello,String seña,String vehiculo){
        this.cabello = cabello;
        this.hobbie = hobbie;
        this.genero = genero;
        this.seña = seña;
        this.vehiculo = vehiculo;
        this.objetoRobado = new ObjetoComun(objetoRobado);
    }
    public void anotarGenero(String genero){
        this.genero = genero;
    }

    public int acuchillar(Policia policiaAcuchillado){

        return policiaAcuchillado.recibirCuchillazo();
    }
}
