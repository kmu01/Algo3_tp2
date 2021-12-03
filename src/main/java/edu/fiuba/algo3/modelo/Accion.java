package edu.fiuba.algo3.modelo;

public class Accion {
    int tiempo = 0;
    public Accion(int tiempoInicial){
        this.tiempo = tiempoInicial;
    }
    public Accion(){}

    public void calcularTiempoQueTardaEnRealizarLaAccion(int cantDeVisitas){
        if (cantDeVisitas == 1){
            this.tiempo = 1;
        }
        else if  (cantDeVisitas == 2){
            this.tiempo = 2;
        }
        else {
            this.tiempo = 3;
        }
    }
}
