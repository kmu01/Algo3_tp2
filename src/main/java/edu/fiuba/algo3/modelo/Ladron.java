package edu.fiuba.algo3.modelo;

public class Ladron {
    private String sexo;
    private String hobbie;
    private String cabello;
    private String seña;
    private String vehiculo;
    private ObjetoRobado objetoRobado;
    public Ladron(String objetoRobado,int cantidadArrestos){

        this.objetoRobado = new ObjetoComun(objetoRobado);
    }

    public Ladron (int cantidadArrestos,String objetoRobado, String sexo,String hobbie,String cabello,String seña,String vehiculo){
        this.cabello = cabello;
        this.hobbie = hobbie;
        this.sexo = sexo;
        this.seña = seña;
        this.vehiculo = vehiculo;
        this.objetoRobado = new ObjetoComun(objetoRobado);
    }
    public void anotarGenero(String genero){
        this.sexo = genero;
    }

    public int acuchillar(Policia policiaAcuchillado){

        return policiaAcuchillado.recibirCuchillazo();
    }
}
