package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class Sargento extends GradoDePolicia {

    public Sargento(){
        super();

        this.tiempoDeViaje = 1500;
        this.tiempoDeDescanso = 8;
        this.dificultad = new Dificultad("Dificil");

    }

    public ObjetoRobado elegirObjeto(List<ObjetoRobado> objetosRobados) {

        int dificultad = (int)Math.floor(Math.random()*(3)+1);
        int dado = 0;
        ObjetoRobado objeto = null;
        List<ObjetoRobado> objetosFiltrados = null;
        switch (dificultad){
            case 1:
                objetosFiltrados = objetosRobados.stream().filter(obj -> obj.rareza().equals("valioso")).collect(Collectors.toList());
                dado = (int)Math.floor(Math.random()*((int)objetosFiltrados.size()));
                objeto = objetosFiltrados.get(dado);

            case 2:
                objetosFiltrados = objetosRobados.stream().filter(obj -> obj.rareza().equals("muy valioso")).collect(Collectors.toList());
                dado = (int)Math.floor(Math.random()*((int)objetosFiltrados.size()));
                objeto = objetosFiltrados.get(dado);

            case 3:
                objetosFiltrados = objetosRobados.stream().filter(obj -> obj.rareza().equals("muy valioso")).collect(Collectors.toList());
                dado = (int)Math.floor(Math.random()*((int)objetosFiltrados.size()));
                objeto = objetosFiltrados.get(dado);
        }
        return objeto;
    }

}