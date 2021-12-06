package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Ladron extends MiembroDeBanda{

    public Ladron (String nombre, String genero, String hobbie, String cabello, String senia, String vehiculo){

        this.nombre = nombre;
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

    public String nombre() {
        return (this.nombre);
    }


    public boolean equals(Ladron ladron)
    {
        if (ladron == this) {
            return true;
        }

        if (ladron == null || ladron.getClass() != getClass()) {
            return false;
        }


        return Objects.equals(this.cabello, ladron.cabello) &&
                Objects.equals(this.hobbie, ladron.hobbie) &&
                Objects.equals(this.genero, ladron.genero) &&
                Objects.equals(this.senia, ladron.senia) &&
                Objects.equals(this.vehiculo, ladron.vehiculo);
    }

    @Override
    public int hashCode() {return Objects.hash(this.cabello, this.hobbie, this.genero, this.senia, this.vehiculo);}
}

