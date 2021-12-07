package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

public abstract class GradoDePolicia {

    protected int tiempoDeViaje;
    protected int tiempoDeDescanso;
    protected int tiempoDeHeridaDeBala;
    protected Dificultad dificultad;
    protected String rarezaMasFrecuente;
    protected String rarezaMenosFrecuente;

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
        List<ObjetoRobado> objetosFiltrados;
        switch (dificultad){
            case 1:
                objetosFiltrados = objetosRobados.stream().filter(obj -> obj.rareza().equals(rarezaMasFrecuente)).collect(Collectors.toList());
                dado = (int)Math.floor(Math.random()*((int)objetosFiltrados.size()));
                objeto = objetosFiltrados.get(dado);

            case 2:
                objetosFiltrados = objetosRobados.stream().filter(obj -> obj.rareza().equals(rarezaMasFrecuente)).collect(Collectors.toList());
                dado = (int)Math.floor(Math.random()*((int)objetosFiltrados.size()));
                objeto = objetosFiltrados.get(dado);

            case 3:
                objetosFiltrados = objetosRobados.stream().filter(obj -> obj.rareza().equals(rarezaMenosFrecuente)).collect(Collectors.toList());
                dado = (int)Math.floor(Math.random()*((int)objetosFiltrados.size()));
                objeto = objetosFiltrados.get(dado);
        }
        return objeto;
    }
}
