package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class GradoDePolicia {

    protected int tiempoDeViaje;
    protected int tiempoDeDescanso;
    protected int tiempoDeHeridaDeBala;
    protected Dificultad dificultadMasFrecuente;
    protected Dificultad dificultadMenosFrecuente;
    protected String rarezaMasFrecuente;
    protected String rarezaMenosFrecuente;
    protected Random r = new Random();

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
        int dificultad = r.nextInt(3+1);
        Pista pista = null;
        switch (dificultad){
            case 1:
                pista = pistas.stream().filter(p -> p.esPista(dificultadMasFrecuente, nombreLugar)).findAny().orElse(null);

            case 2:
                pista = pistas.stream().filter(p -> p.esPista(dificultadMasFrecuente, nombreLugar)).findAny().orElse(null);

            case 3:
                pista = pistas.stream().filter(p -> p.esPista(dificultadMenosFrecuente, nombreLugar)).findAny().orElse(null);
        }
        return pista;
    }

    public ObjetoRobado elegirObjeto(List<ObjetoRobado> objetosRobados) {
        int dificultad = r.nextInt(3+1);
        ObjetoRobado objeto = null;
        List<ObjetoRobado> objetosFiltrados;
        switch (dificultad){
            case 1:
                objetosFiltrados = objetosRobados.stream().filter(obj -> obj.rareza().equals(rarezaMasFrecuente)).collect(Collectors.toList());
                objeto = objetosFiltrados.get(r.nextInt(objetosFiltrados.size()));

            case 2:
                objetosFiltrados = objetosRobados.stream().filter(obj -> obj.rareza().equals(rarezaMasFrecuente)).collect(Collectors.toList());
                objeto = objetosFiltrados.get(r.nextInt(objetosFiltrados.size()));

            case 3:
                objetosFiltrados = objetosRobados.stream().filter(obj -> obj.rareza().equals(rarezaMenosFrecuente)).collect(Collectors.toList());
                objeto = objetosFiltrados.get(r.nextInt(objetosFiltrados.size()));
        }
        return objeto;
    }
}
