package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class GradoDePolicia {

    protected int tiempoDeViaje;
    protected int tiempoDeDescanso;
    protected int tiempoDeHeridaDeBala;
    protected Dificultad dificultad;

    public GradoDePolicia (){}

    public void calcularTiempoDeViaje(float distancia, Cronometro cronometro) {

        cronometro.calcularTiempoDeViaje(distancia, this.tiempoDeViaje);

    }

    public void calcularTiempoDeBalazo(Cronometro cronometro){
        cronometro.calcularTiempoDeBalazo(this.tiempoDeHeridaDeBala);
    }

    public void calcularTiempoDurmiendo(Cronometro cronometro) {

        cronometro.calcularTiempoDurmiendo(this.tiempoDeDescanso);

    }

    public Pista buscarPista(List<Pista> pistas,String nombreLugar){
        Pista pistaSeleccionada = null;
        for (int i = 0 ; i < pistas.size() ; i++){
            Pista pista = pistas.get(i);
            if(pista.esPista(this.dificultad,nombreLugar)){
                pistaSeleccionada = pista;
            };
        }
        return pistaSeleccionada;
    }

    public ObjetoRobado elegirObjeto(List<ObjetoRobado> objetosRobados) {

        int dificultad = (int)Math.floor(Math.random()*(3)+1);
        int dado = 0;
        ObjetoRobado objeto = null;

        switch (dificultad){
            case 1:
                List<ObjetoRobado> comunes = objetosRobados.stream().filter(obj -> obj.rareza().equals("comun")).collect(Collectors.toList());
                dado = (int)Math.floor(Math.random()*((int)comunes.size()));
                objeto = comunes.get(dado);

            case 2:
                List<ObjetoRobado> valiosos = objetosRobados.stream().filter(obj -> obj.rareza().equals("valioso")).collect(Collectors.toList());
                dado = (int)Math.floor(Math.random()*((int)valiosos.size()));
                objeto = valiosos.get(dado);

            case 3:
                List<ObjetoRobado> muyValiosos = objetosRobados.stream().filter(obj -> obj.rareza().equals("muy valioso")).collect(Collectors.toList());
                dado = (int)Math.floor(Math.random()*((int)muyValiosos.size()));
                objeto = muyValiosos.get(dado);
        }
        return objeto;
    }
}
